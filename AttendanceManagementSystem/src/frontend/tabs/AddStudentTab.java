package frontend.tabs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import classes.Student;
import classes.User;
import frontend.Main;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddStudentTab {
	
	public JPanel addStudentTab;
	
	private JTextField addressField;
	private JTextField nameField;
	
	private JTextField contactField;
	private JTextField passwordField;
	
	private Font titleFont = new Font("Calibri", Font.BOLD, 30);
	private Font baseFont = new Font("Calibri", Font.BOLD, 20);
	private JTextField emailField;
	private JTextField grNoField;
	private JTextField yearField;
	private JTextField divisionField;
	private JTextField rollNoField;
	
	public AddStudentTab() {		
		addStudentTab = new JPanel();
		addStudentTab.setLayout(null);
		
		JLabel titleLabel = new JLabel("Add Student");
		titleLabel.setBounds(654, 10, 250, 46);
		titleLabel.setFont(titleFont);
		addStudentTab.add(titleLabel);
		
		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(165, 200, 100, 30);
		nameLabel.setFont(baseFont);
		addStudentTab.add(nameLabel);
		
		JLabel emailLabel = new JLabel("Email ID:");
		emailLabel.setFont(baseFont);
		emailLabel.setBounds(165, 250, 100, 30);
		addStudentTab.add(emailLabel);
		
		JLabel personalDetailsLabel = new JLabel("Personal Details");
		personalDetailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		personalDetailsLabel.setFont(baseFont);
		personalDetailsLabel.setBounds(250, 137, 200, 30);
		addStudentTab.add(personalDetailsLabel);
		
		JLabel grNoLabel = new JLabel("GR No.:");
		grNoLabel.setFont(baseFont);
		grNoLabel.setBounds(860, 200, 100, 30);
		addStudentTab.add(grNoLabel);
		
		JLabel lblAcademicDetails = new JLabel("Academic Details");
		lblAcademicDetails.setFont(baseFont);
		lblAcademicDetails.setBounds(906, 137, 250, 30);
		addStudentTab.add(lblAcademicDetails);
		
		JLabel departmentLabel = new JLabel("Department: ");
		departmentLabel.setFont(baseFont);
		departmentLabel.setBounds(860, 250, 150, 30);
		addStudentTab.add(departmentLabel);
		
		JLabel yearLabel = new JLabel("Year: ");
		yearLabel.setFont(baseFont);
		yearLabel.setBounds(860, 300, 69, 30);
		addStudentTab.add(yearLabel);
		
		JLabel editLabel = new JLabel("");
		editLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editLabel.setFont(baseFont);
		editLabel.setBounds(589, 531, 400, 30);
		addStudentTab.add(editLabel);
		
		JLabel contactLabel = new JLabel("Contact No.: ");
		contactLabel.setFont(baseFont);
		contactLabel.setBounds(165, 300, 150, 30);
		addStudentTab.add(contactLabel);
		
		JLabel divisionLabel = new JLabel("Division: ");
		divisionLabel.setFont(baseFont);
		divisionLabel.setBounds(860, 350, 100, 30);
		addStudentTab.add(divisionLabel);
		
		JLabel rollNoLabel = new JLabel("Roll No.:");
		rollNoLabel.setFont(baseFont);
		rollNoLabel.setBounds(860, 400, 100, 30);
		addStudentTab.add(rollNoLabel);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		addressLabel.setBounds(165, 350, 100, 30);
		addStudentTab.add(addressLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		passwordLabel.setBounds(165, 400, 150, 30);
		addStudentTab.add(passwordLabel);
		
		addressField = new JTextField();
		addressField.setFont(new Font("Dialog", Font.PLAIN, 20));
		addressField.setBounds(300, 350, 250, 30);
		addStudentTab.add(addressField);
		addressField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Dialog", Font.PLAIN, 20));
		nameField.setBounds(300, 200, 250, 30);
		addStudentTab.add(nameField);
		nameField.setColumns(10);
		
		contactField = new JTextField();
		contactField.setFont(new Font("Dialog", Font.PLAIN, 20));
		contactField.setBounds(300, 300, 250, 30);
		addStudentTab.add(contactField);
		contactField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 20));
		passwordField.setBounds(305, 400, 250, 26);
		addStudentTab.add(passwordField);
		passwordField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Dialog", Font.PLAIN, 20));
		emailField.setBounds(300, 250, 250, 30);
		addStudentTab.add(emailField);
		emailField.setColumns(10);
		
		grNoField = new JTextField();
		grNoField.setFont(new Font("Dialog", Font.PLAIN, 20));
		grNoField.setColumns(10);
		grNoField.setBounds(1000, 200, 250, 30);
		addStudentTab.add(grNoField);
		
		yearField = new JTextField();
		yearField.setFont(new Font("Dialog", Font.PLAIN, 20));
		yearField.setColumns(10);
		yearField.setBounds(1000, 305, 250, 30);
		addStudentTab.add(yearField);
		
		divisionField = new JTextField();
		divisionField.setFont(new Font("Dialog", Font.PLAIN, 20));
		divisionField.setColumns(10);
		divisionField.setBounds(1000, 355, 250, 30);
		addStudentTab.add(divisionField);
		
		rollNoField = new JTextField();
		rollNoField.setFont(new Font("Dialog", Font.PLAIN, 20));
		rollNoField.setColumns(10);
		rollNoField.setBounds(1000, 400, 250, 30);
		addStudentTab.add(rollNoField);
		
		JComboBox<String> departmentDropdown = new JComboBox<String>();
		departmentDropdown.setModel(new DefaultComboBoxModel<String>(new String[] {"Computer", "Mechnical", "Chemical", "Instrumentation"}));
		departmentDropdown.setFont(new Font("Dialog", Font.PLAIN, 20));
		departmentDropdown.setBounds(1000, 250, 250, 30);
		addStudentTab.add(departmentDropdown);
		
		JButton saveButton = new JButton("Save");
		saveButton.setForeground(Color.BLACK);
		saveButton.setBackground(Color.WHITE);
		saveButton.setFont(baseFont);
		saveButton.setBounds(544, 571, 171, 52);
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String email = emailField.getText();
				String phone = nameField.getText();
				String address = addressField.getText();
				String password = passwordField.getText();
				
				int grNo = Integer.parseInt(grNoField.getText());
				String department = departmentDropdown.getSelectedItem().toString();
				int divisionId = Integer.parseInt(divisionField.getText());
				int year = Integer.parseInt(yearField.getText());
				
				User.insertUser(Main.db, email, password, "STUDENT");
				User u = User.login(Main.db, email, password);
				Student.insert(Main.db, u.getId(), divisionId, name, year, department, grNo, phone, address);
				
				editLabel.setText("Student added successfully.");
			}
		});
		addStudentTab.add(saveButton);
	}
}
