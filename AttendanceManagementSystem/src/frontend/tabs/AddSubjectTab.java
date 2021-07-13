package frontend.tabs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import classes.Subject;
import frontend.Main;

public class AddSubjectTab {
	
	public JPanel addSubjectTab;
	
	private JTextField nameField;
	private JTextField teacherField, divisionField;
	
	private Font titleFont = new Font("Calibri", Font.BOLD, 30);
	private Font baseFont = new Font("Calibri", Font.BOLD, 20);
	
	public AddSubjectTab() {		
		addSubjectTab = new JPanel();
		addSubjectTab.setLayout(null);
		
		JLabel titleLabel = new JLabel("Add Subject");
		titleLabel.setBounds(654, 10, 250, 46);
		titleLabel.setFont(titleFont);
		addSubjectTab.add(titleLabel);
		
		JLabel detailsLabel = new JLabel("Subject Details");
		detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		detailsLabel.setFont(baseFont);
		detailsLabel.setBounds(250, 137, 200, 30);
		addSubjectTab.add(detailsLabel);
		
		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(165, 200, 100, 30);
		nameLabel.setFont(baseFont);
		addSubjectTab.add(nameLabel);
		
		JLabel departmentLabel = new JLabel("Department: ");
		departmentLabel.setFont(baseFont);
		departmentLabel.setBounds(165, 250, 150, 30);
		addSubjectTab.add(departmentLabel);
		
		JLabel teacherLabel = new JLabel("Teacher ID: ");
		teacherLabel.setFont(baseFont);
		teacherLabel.setBounds(165, 300, 150, 30);
		addSubjectTab.add(teacherLabel);
		
		JLabel divisionLabel = new JLabel("Division ID: ");
		divisionLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		divisionLabel.setBounds(165, 350, 150, 30);
		addSubjectTab.add(divisionLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Dialog", Font.PLAIN, 20));
		nameField.setBounds(300, 200, 250, 30);
		addSubjectTab.add(nameField);
		nameField.setColumns(10);
		
		teacherField = new JTextField();
		teacherField.setFont(new Font("Dialog", Font.PLAIN, 20));
		teacherField.setColumns(10);
		teacherField.setBounds(300, 300, 250, 30);
		addSubjectTab.add(teacherField);
		
		divisionField = new JTextField();
		divisionField.setFont(new Font("Dialog", Font.PLAIN, 20));
		divisionField.setColumns(10);
		divisionField.setBounds(300, 350, 250, 30);
		addSubjectTab.add(divisionField);
		
		JComboBox<String> departmentDropdown = new JComboBox<String>();
		departmentDropdown.setModel(new DefaultComboBoxModel<String>(new String[] {"Computer", "Mechanical", "Chemical", "Instrumentation"}));
		departmentDropdown.setFont(new Font("Dialog", Font.PLAIN, 20));
		departmentDropdown.setBounds(300, 250, 250, 30);
		addSubjectTab.add(departmentDropdown);
		
		JLabel editLabel = new JLabel("");
		editLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editLabel.setFont(baseFont);
		editLabel.setBounds(589, 531, 400, 30);
		addSubjectTab.add(editLabel);
		
		JButton saveButton = new JButton("Save");
		saveButton.setForeground(Color.BLACK);
		saveButton.setBackground(Color.WHITE);
		saveButton.setFont(baseFont);
		saveButton.setBounds(544, 571, 171, 52);
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String department = departmentDropdown.getSelectedItem().toString();
				int teacherId = Integer.parseInt(teacherField.getText());
				int divisionId = Integer.parseInt(divisionField.getText());

				Subject.insert(Main.db, teacherId, divisionId, name, department);
				
				editLabel.setText("Subject added successfully.");
			}
		});
		addSubjectTab.add(saveButton);
	}
}
