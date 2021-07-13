package frontend;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.jdatepicker.*;

import classes.*;
import frontend.tabs.NoticeTab;
import frontend.tabs.ProfileTab;

public class TeacherDashboard extends JFrame {

	private static final long serialVersionUID = -8695521241625659857L;
	private JPanel profile;
	private JPanel attendance;
	private JPanel viewnotice;

	private Font baseFont = new Font("Calibri", Font.BOLD, 20);

	// Attendance
	private JTable studentList;
	private TeacherTableModel tableModel;

	TableRowSorter<TableModel> sorter;

	public TeacherDashboard(Teacher t) {
		JTabbedPane teacherPane = new JTabbedPane(JTabbedPane.TOP);

		// Profile panel
		ProfileTab profileTab = new ProfileTab(t);
		profile = profileTab.profile;
		teacherPane.add("Profile", profile);
		profile.setLayout(null);


		// Attendance Pane
		attendance = new JPanel();

		teacherPane.add("Attendance", attendance);
		attendance.setLayout(null);

		JButton getStudents = new JButton("Fetch students");
		getStudents.setBounds(488, 58, 130, 23);
		attendance.add(getStudents);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 99, 873, 520);
		attendance.add(scrollPane);

		JComboBox<String> departmentDropdown = new JComboBox<String>();
		departmentDropdown.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Computer", "Mechanical", "Chemical", "Instrumentation", "Information Technology" }));
		departmentDropdown.setSelectedIndex(0);
		departmentDropdown.setBounds(129, 17, 170, 27);
		attendance.add(departmentDropdown);

		JLabel departmentDropdownLabel = new JLabel("Department");
		departmentDropdownLabel.setBounds(46, 21, 90, 16);
		attendance.add(departmentDropdownLabel);

		JLabel subjectDropdownLabel = new JLabel("Subject");
		subjectDropdownLabel.setBounds(583, 23, 69, 16);
		attendance.add(subjectDropdownLabel);

		JComboBox<String> subjectDropdown = new JComboBox<String>();
		subjectDropdown.setBounds(637, 19, 170, 27);
		attendance.add(subjectDropdown);

		JLabel divisionDropdownLocal = new JLabel("Division");
		divisionDropdownLocal.setBounds(325, 23, 69, 16);
		attendance.add(divisionDropdownLocal);

		JComboBox<String> divisionDropdown = new JComboBox<String>();
		divisionDropdown.setBounds(379, 19, 170, 27);
		attendance.add(divisionDropdown);

		JDatePicker datePicker = new JDatePicker();
		datePicker.setBounds(47, 56, 200, 30);
		attendance.add(datePicker);

		JComboBox<String> timingDropdown = new JComboBox<String>();

		String hours[] = new String[24];
		for (int hour=0; hour < 24; hour++) {
			if (0 < hour && hour < 12)
				hours[hour] = String.format("%02d:00am", hour);
			else if (hour == 0)
				hours[hour] = String.format("12:00am");
			else
				hours[hour] = String.format("%02d:00pm", hour-12);
		}
		ComboBoxModel<String> hourList = new DefaultComboBoxModel<String>(hours);

		timingDropdown.setModel(hourList);
		timingDropdown.setSelectedIndex(-1);
		timingDropdown.setBounds(289, 56, 170, 27);
		attendance.add(timingDropdown);

		JButton saveButton = new JButton("Save Attendance");
		saveButton.setBounds(647, 55, 150, 29);
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int idx = 0; idx < tableModel.getRowCount(); idx++) {
					tableModel.getValueAt(idx, 0);
					String name = String.valueOf(tableModel.getValueAt(idx, 1));
					boolean present = (boolean) tableModel.getValueAt(idx, 2);
					// System.out.println(String.format("Marking '%s' present as '%b'", name, present));
				}

				for (int idx = 0; idx < tableModel.attendance.size(); idx++) {
					Object[] arr = tableModel.attendance.get(idx);

					int studentId = (int) arr[0];
					String.valueOf(arr[1]);
					boolean present = (boolean) tableModel.getValueAt(idx, 2);
					int attendanceId = (int) arr[3];

					if (attendanceId != 0) {
						Attendance att = Attendance.getById(Main.db, attendanceId);
						att.present = present;
						att.update(Main.db);
					} else {
						departmentDropdown.getSelectedItem().toString();
						String division = divisionDropdown.getSelectedItem().toString();
						Integer.parseInt(division.split(" - ")[0]);

						String subject = subjectDropdown.getSelectedItem().toString();
						int subjectId = Integer.parseInt(subject.split(" - ")[0]);


						Calendar date = (Calendar) datePicker.getModel().getValue();
						int year = date.get(Calendar.YEAR);
						int month = date.get(Calendar.MONTH);
						int day = date.get(Calendar.DATE);

						String time = timingDropdown.getSelectedItem().toString();
						int hour = Integer.parseInt(time.split(":")[0]);

						Attendance.insert(Main.db, studentId, subjectId, year, month, day, hour, present);
					}
				}
			}
		});
		attendance.add(saveButton);

		// Student Table
		tableModel = new TeacherTableModel();
		studentList = new JTable(tableModel);
		studentList.setFont(new Font("Calibri", Font.PLAIN, 20));
		studentList.getTableHeader().setFont(baseFont);
		studentList.setRowHeight(40);

		scrollPane.setViewportView(studentList);

		// Drop down Logic
		departmentDropdown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String dept = departmentDropdown.getSelectedItem().toString();
				ArrayList<String> divisions = new ArrayList<String>();

				for (Division d : Division.getDepartmentDivisions(Main.db, dept)) {
					divisions.add(String.format("%d - %s", d.getId(), d.name));
				}
				divisionDropdown.setModel(new DefaultComboBoxModel(divisions.toArray()));
				subjectDropdown.setModel(new DefaultComboBoxModel<String>(new String[] {}));
				divisionDropdown.setSelectedIndex(-1);
			}
		});

		divisionDropdown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (divisionDropdown.getSelectedItem() == null)
					return;
				String division = divisionDropdown.getSelectedItem().toString();
				int divisionId = Integer.parseInt(division.split(" - ")[0]);

				ArrayList<String> subjects = new ArrayList<String>();

				for (Subject s : Subject.getDivisionSubjects(Main.db, divisionId)) {
					subjects.add(String.format("%d - %s", s.getId(), s.name));
				}
				subjectDropdown.setModel(new DefaultComboBoxModel(subjects.toArray()));
			}
		});

		// Fetch Students
		getStudents.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String dept = departmentDropdown.getSelectedItem().toString();
				if (divisionDropdown.getSelectedItem() == null)
					return;
				String division = divisionDropdown.getSelectedItem().toString();
				int divisionId = Integer.parseInt(division.split(" - ")[0]);

				if (subjectDropdown.getSelectedItem() == null)
					return;
				String subject = subjectDropdown.getSelectedItem().toString();
				int subjectId = Integer.parseInt(subject.split(" - ")[0]);

				if (datePicker.getModel().getValue() == null)
					return;
				Calendar lectureDate = (Calendar) datePicker.getModel().getValue();

				if (timingDropdown.getSelectedItem() == null)
					return;
				String time = timingDropdown.getSelectedItem().toString();
				int hour = Integer.parseInt(time.split(":")[0]);

				ArrayList<Object[]> students = new ArrayList<Object[]>();

				for (Student s: Student.getDivisionStudents(Main.db, divisionId)) {
					Object[] arr = {s.getId(), s.grNo, s.name, false, 0};

					Attendance att = Attendance.getLectureAttendanceForStudent(Main.db, s.getId(), subjectId, lectureDate, hour);
					if (att != null) {
						arr[4] = att.getId();
						arr[3] = att.present;
					}
					students.add(arr);
				}
				tableModel.update(students);
				studentList.updateUI();
			}
		});

		// Notice Board:
		NoticeTab notice = new NoticeTab(false);
		viewnotice = notice.viewnotice;
		teacherPane.add("Notice", viewnotice);
		viewnotice.setLayout(null);


		getContentPane().add(teacherPane, BorderLayout.CENTER);
	}
}

class TeacherTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 506595258947463930L;
	private String names[] = {"Student ID", "GR No.", "Name", "Present"};
	private Object data[][] = {{2, 1191002, "Vishal T", true}, {1, 1191002, "Utsav T", false}};
	ArrayList<Object[]> attendance;

	public TeacherTableModel() {
		super();
	}

	public void update(ArrayList<Object[]> students) {
		// ID GRNO NAME PRESENT HAS_ATT
		Object attArray[][] = new Object[students.size()][];
		int index = 0;

		for (Object[] st : students) {
			Object[] arr = new Object[4];
			Arrays.fill(arr, 0);

			arr[0] = st[0];
			arr[1] = st[1];
			arr[2] = st[2];
			arr[3] = st[3];

			attArray[index] = arr;
			index++;
		}
		this.data = attArray;
		this.attendance = students;
		this.fireTableRowsUpdated(0, 1);

	}


	public int getColumnCount() {
		return this.names.length;
	}
	public int getRowCount() {
		return this.data.length;
	}

	public String getColumnName(int idx) {
		return this.names[idx];
	}
	public Object getValueAt(int row, int col) {
		return this.data[row][col];
	}

	public Class getColumnClass(int idx) {
		return getValueAt(0, idx).getClass();
	}

	public boolean isCellEditable(int row, int col) {
        if (col == 2) {
            return true;
        } else {
            return false;
        }
    }

	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}
}