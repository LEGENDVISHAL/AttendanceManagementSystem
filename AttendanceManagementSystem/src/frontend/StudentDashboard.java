package frontend;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import classes.*;
import frontend.tabs.NoticeTab;
import frontend.tabs.ProfileTab;

public class StudentDashboard extends JFrame{

	private static final long serialVersionUID = 8078890563061104737L;
	private JTabbedPane studentPane;
	private JPanel profileTab, attendanceTab, noticeTab;

	private Font baseFont = new Font("Calibri", Font.BOLD, 20);

	// Table
	TableRowSorter<TableModel> sorter;
	JButton defaulterButton;


	public StudentDashboard(Student st) {
		this.setTitle("Student Dashboard");

		studentPane = new JTabbedPane(JTabbedPane.TOP);
		attendanceTab = new JPanel();
		profileTab = new JPanel();

		// Profile panel
		ProfileTab profile = new ProfileTab(st);
		profileTab = profile.profile;
		studentPane.add("Profile", profileTab);
		profileTab.setLayout(null);


		// Attendance
		studentPane.add("Attendance", attendanceTab);
		StudentTableModel tableModel = new StudentTableModel(st);

		JTable attendanceTable = new JTable(tableModel);
		attendanceTable.setFont(new Font("Calibri", Font.PLAIN, 20));
		attendanceTable.getTableHeader().setFont(baseFont);
		attendanceTable.getColumnModel().getColumn(0).setMinWidth(30);
		attendanceTable.getColumnModel().getColumn(0).setMaxWidth(120);
		attendanceTable.getColumnModel().getColumn(1).setMinWidth(90);
		attendanceTable.getColumnModel().getColumn(1).setMaxWidth(300);
		attendanceTable.getColumnModel().getColumn(2).setMinWidth(110);
		attendanceTable.getColumnModel().getColumn(2).setMaxWidth(130);
		attendanceTable.getColumnModel().getColumn(3).setMaxWidth(110);
		attendanceTable.getColumnModel().getColumn(3).setMinWidth(130);
		attendanceTable.getColumnModel().getColumn(4).setMinWidth(150);
		attendanceTable.getColumnModel().getColumn(4).setMaxWidth(150);
		attendanceTable.getColumnModel().getColumn(5).setMinWidth(250);
		attendanceTable.setRowHeight(50);
		attendanceTable.setCellSelectionEnabled(true);

		// Sorting and Filtering
		sorter = new TableRowSorter<TableModel>(attendanceTable.getModel());
		attendanceTable.setRowSorter(sorter);

//		defaulterFilter(90);
		attendanceTab.setLayout(null);

//		JPanel attendancePanel = new JPanel();
//		attendancePanel.setBounds(193, 26, 1134, 626);
//		attendancePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Attendance Record"));
//		attendancePanel.setLayout(null);

		// Table Scrolling
		JScrollPane scrollPane = new JScrollPane(attendanceTable);
		scrollPane.setFont(new Font("Calibri", Font.PLAIN, 20));
		scrollPane.setBounds(20, 37, 1114, 595);
		attendanceTable.setFillsViewportHeight(true);

		attendanceTab.add(scrollPane);

		defaulterButton = new JButton("Show Defaulter Subjects");
		defaulterButton.setBounds(10, 6, 200, 29);
		defaulterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (defaulterButton.getText().equals("Show Defaulter Subjects")) {
					defaulterFilter(60);
					defaulterButton.setText("Hide Defaulter Subjects");
				}
				else {
					defaulterFilter(101);
					defaulterButton.setText("Show Defaulter Subjects");
				}
			}
		});
		attendanceTab.add(defaulterButton);

		// Notice Board
		NoticeTab notice = new NoticeTab(false);
		noticeTab = notice.viewnotice;
		studentPane.add("Notice", noticeTab);
		noticeTab.setLayout(null);


		getContentPane().add(studentPane, BorderLayout.CENTER);
	}

	private void defaulterFilter(int cutoff) {
		RowFilter<TableModel, Object> rf = null;
		rf = RowFilter.numberFilter(ComparisonType.BEFORE, cutoff, 4);
		sorter.setRowFilter(rf);
	};
}

class StudentTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -3259743192147940171L;
	private String names[] = {"Subject ID", "Subject", "Present", "Total", "Percentage", "Lectures to attend for 75%"};
	private Object data[][];

	public StudentTableModel(Student st) {
		super();
		ArrayList<Subject> subjects = Subject.getDivisionSubjects(Main.db, st.divisionId);

		Object attArray[][] = new Object[subjects.size()][];
		int index = 0;

		for (Subject sub : subjects) {

			// Get Attendance by subject and student
			ArrayList<Attendance> subjectAttendance = Attendance.getStudentAttendanceForSubject(Main.db, st.getId(), sub.getId());

			int present = 0;
			for (Attendance att : subjectAttendance) {
				if (att.present)
					present++;
			}

			Object[] arr = new Object[6];
			Arrays.fill(arr, 0);

			arr[0] = sub.getId();
			arr[1] = sub.name;
			arr[2] = present;
			arr[3] = subjectAttendance.size();

			attArray[index] = arr;
			index++;
		}
		this.data = attArray;
		this.findPercent();
	}

	public void findPercent() {
		for(Object[] x: this.data) {
			int present = (int) x[2];
			int total = (int) x[3];

			float temp = 0;
			int attend = 0;
			if (total > 0) {
				temp = (present / (float) total) * 100;

				// TODO Find better solution
				while (temp < 75) {
					attend++;
					temp = ((present+attend) / (float) (total+attend)) * 100;
				}
			}
			if (total > 0)
				x[4] = (present / (float) total) * 100;
			else
				x[4] = 0;
			x[5] = attend;
		}
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
        if (col == 4) {
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