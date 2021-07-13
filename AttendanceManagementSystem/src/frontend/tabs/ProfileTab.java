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
import javax.swing.SwingUtilities;

import classes.Admin;
import classes.Student;
import classes.Teacher;
import frontend.LoginGUI;
import frontend.Main;

public class ProfileTab {

	public JPanel profile;

	private JTextField addressField;
	private JTextField nameField;

	private Student student;
	private Teacher teacher;
	private Admin admin;

	private JTextField contactField;
	private JTextField passwordField;
	private JButton editButton;

	private Font titleFont = new Font("Calibri", Font.BOLD, 30);
	private Font baseFont = new Font("Calibri", Font.BOLD, 20);

	public ProfileTab(Student st) {
		this.student = st;

		profile = new JPanel();

		JLabel stdprofilelbl = new JLabel("Student Profile");
		stdprofilelbl.setBounds(654, 10, 250, 46);
		stdprofilelbl.setFont(titleFont);
		profile.add(stdprofilelbl);

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(165, 200, 100, 30);
		nameLabel.setFont(baseFont);
		profile.add(nameLabel);

		JLabel emailLabel = new JLabel("Email ID:");
		emailLabel.setFont(baseFont);
		emailLabel.setBounds(165, 250, 100, 30);
		profile.add(emailLabel);

		JLabel personalDetailsLabel = new JLabel("Personal Details");
		personalDetailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		personalDetailsLabel.setFont(baseFont);
		personalDetailsLabel.setBounds(250, 137, 200, 30);
		profile.add(personalDetailsLabel);

		JLabel grNoLabel = new JLabel("GR No.:");
		grNoLabel.setFont(baseFont);
		grNoLabel.setBounds(860, 200, 100, 30);
		profile.add(grNoLabel);

		JLabel lblAcademicDetails = new JLabel("Academic Details");
		lblAcademicDetails.setFont(baseFont);
		lblAcademicDetails.setBounds(906, 137, 250, 30);
		profile.add(lblAcademicDetails);

		JLabel departmentLabel = new JLabel("Department: ");
		departmentLabel.setFont(baseFont);
		departmentLabel.setBounds(860, 250, 150, 30);
		profile.add(departmentLabel);

		JLabel yearLabel = new JLabel("Year: ");
		yearLabel.setFont(baseFont);
		yearLabel.setBounds(860, 300, 69, 30);
		profile.add(yearLabel);

		JLabel editLabel = new JLabel("");
		editLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editLabel.setFont(baseFont);
		editLabel.setBounds(589, 531, 400, 30);
		profile.add(editLabel);


		JLabel nameLabelValue = new JLabel(this.student.name);
		nameLabelValue.setFont(new Font("Calibri", Font.PLAIN, 20));
		nameLabelValue.setBounds(305, 200, 250, 30);
		profile.add(nameLabelValue);

		JLabel emailLabelValue = new JLabel(this.student.email);
		emailLabelValue.setFont(new Font("Calibri", Font.PLAIN, 20));
		emailLabelValue.setBounds(305, 250, 250, 30);
		profile.add(emailLabelValue);

		JLabel grNoLabelValue = new JLabel("11910001");
		grNoLabelValue.setFont(new Font("Calibri", Font.PLAIN, 20));
		grNoLabelValue.setBounds(1015, 200, 250, 30);
		profile.add(grNoLabelValue);

		JLabel departmentLabelValue = new JLabel(this.student.department);
		departmentLabelValue.setFont(new Font("Calibri", Font.PLAIN, 20));
		departmentLabelValue.setBounds(1015, 250, 250, 30);
		profile.add(departmentLabelValue);

		JLabel yearLabelValue = new JLabel(String.valueOf(this.student.year));
		yearLabelValue.setFont(new Font("Dialog", Font.PLAIN, 20));
		yearLabelValue.setBounds(1015, 300, 250, 30);
		profile.add(yearLabelValue);

		JLabel contactLabel = new JLabel("Contact No.: ");
		contactLabel.setFont(baseFont);
		contactLabel.setBounds(165, 300, 150, 30);
		profile.add(contactLabel);

		JLabel contactLabelValue = new JLabel(this.student.phone);
		contactLabelValue.setFont(new Font("Dialog", Font.PLAIN, 20));
		contactLabelValue.setBounds(305, 300, 250, 30);
		profile.add(contactLabelValue);

		JLabel divisionLabel = new JLabel("Division: ");
		divisionLabel.setFont(baseFont);
		divisionLabel.setBounds(860, 350, 100, 30);
		profile.add(divisionLabel);

		JLabel divisionLabelValue = new JLabel(this.student.division.name);
		divisionLabelValue.setFont(new Font("Dialog", Font.PLAIN, 20));
		divisionLabelValue.setBounds(1015, 350, 250, 30);
		profile.add(divisionLabelValue);

		JLabel rollNoLabel = new JLabel("Roll No.:");
		rollNoLabel.setFont(baseFont);
		rollNoLabel.setBounds(860, 400, 100, 30);
		profile.add(rollNoLabel);

		JLabel rollNoLabelValue = new JLabel("NOT IN DB");
		rollNoLabelValue.setFont(new Font("Dialog", Font.PLAIN, 20));
		rollNoLabelValue.setBounds(1015, 400, 250, 30);
		profile.add(rollNoLabelValue);

		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		addressLabel.setBounds(165, 350, 100, 30);
		profile.add(addressLabel);

		JLabel addressLabelValue = new JLabel(this.student.address);
		addressLabelValue.setFont(new Font("Dialog", Font.PLAIN, 20));
		addressLabelValue.setBounds(305, 350, 250, 30);
		profile.add(addressLabelValue);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		passwordLabel.setBounds(165, 400, 150, 30);
		profile.add(passwordLabel);

		JLabel passwordLabelValue = new JLabel("*".repeat(this.student.password.length()));
		passwordLabelValue.setFont(new Font("Dialog", Font.PLAIN, 20));
		passwordLabelValue.setBounds(305, 400, 250, 30);
		profile.add(passwordLabelValue);


		addressField = new JTextField();
		addressField.setFont(new Font("Dialog", Font.PLAIN, 20));
		addressField.setBounds(300, 350, 250, 30);
		profile.add(addressField);
		addressField.setColumns(10);
		addressField.setVisible(false);

		nameField = new JTextField();
		nameField.setFont(new Font("Dialog", Font.PLAIN, 20));
		nameField.setBounds(300, 200, 250, 30);
		profile.add(nameField);
		nameField.setColumns(10);
		nameField.setVisible(false);

		contactField = new JTextField();
		contactField.setFont(new Font("Dialog", Font.PLAIN, 20));
		contactField.setBounds(300, 300, 250, 30);
		profile.add(contactField);
		contactField.setColumns(10);
		contactField.setVisible(false);

		passwordField = new JTextField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 20));
		passwordField.setBounds(305, 400, 250, 26);
		profile.add(passwordField);
		passwordField.setColumns(10);
		passwordField.setVisible(false);

		JButton saveButton = new JButton("Save");
		saveButton.setForeground(Color.BLACK);
		saveButton.setBackground(Color.WHITE);
		saveButton.setFont(baseFont);
		saveButton.setBounds(544, 571, 171, 52);
		saveButton.setVisible(false);
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nameField.setVisible(false);
				contactField.setVisible(false);
				addressField.setVisible(false);
				passwordField.setVisible(false);

				st.name = nameField.getText();
				st.phone = contactField.getText();
				st.address = addressField.getText();
				st.password = passwordField.getText();
				st.update(Main.db);
				nameLabelValue.setText(st.name);
				contactLabelValue.setText(st.phone);
				addressLabelValue.setText(st.address);
				passwordLabelValue.setText("*".repeat(st.password.length()));

				editLabel.setText("Profile saved successfully.");

				nameLabelValue.setVisible(true);
				contactLabelValue.setVisible(true);
				addressLabelValue.setVisible(true);
				passwordLabelValue.setVisible(true);

				saveButton.setVisible(false);
				editButton.setVisible(true);
			}
		});
		profile.add(saveButton);

		editButton = new JButton("Edit Profile");
		editButton.setForeground(Color.BLACK);
		editButton.setBackground(Color.WHITE);
		editButton.setBounds(544, 571, 171, 52);
		editButton.setFont(baseFont);

		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				nameLabelValue.setVisible(false);
				contactLabelValue.setVisible(false);
				addressLabelValue.setVisible(false);
				passwordLabelValue.setVisible(false);

				nameField.setVisible(true);
				nameField.setText(st.name);

				contactField.setVisible(true);
				contactField.setText(st.phone);

				addressField.setVisible(true);
				addressField.setText(st.address);

				passwordField.setVisible(true);
				passwordField.setText(st.password);

				editLabel.setText("Edit your profile");
				editButton.setVisible(false);
				saveButton.setVisible(true);
			}
			});
		profile.add(editButton);

		this.addLogoutButton();
	}

	public ProfileTab(Teacher t) {
		this.teacher = t;

		profile = new JPanel();

		JLabel stdprofilelbl = new JLabel("Teacher Profile");
		stdprofilelbl.setBounds(654, 10, 250, 46);
		stdprofilelbl.setFont(titleFont);
		profile.add(stdprofilelbl);

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(165, 200, 100, 30);
		nameLabel.setFont(baseFont);
		profile.add(nameLabel);

		JLabel emailLabel = new JLabel("Email ID:");
		emailLabel.setFont(baseFont);
		emailLabel.setBounds(165, 250, 100, 30);
		profile.add(emailLabel);

		JLabel personalDetailsLabel = new JLabel("Personal Details");
		personalDetailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		personalDetailsLabel.setFont(baseFont);
		personalDetailsLabel.setBounds(250, 137, 200, 30);
		profile.add(personalDetailsLabel);

		JLabel grNoLabel = new JLabel("GR No.:");
		grNoLabel.setFont(baseFont);
		grNoLabel.setBounds(860, 200, 100, 30);
		profile.add(grNoLabel);

		JLabel lblAcademicDetails = new JLabel("Academic Details");
		lblAcademicDetails.setFont(baseFont);
		lblAcademicDetails.setBounds(906, 137, 250, 30);
		profile.add(lblAcademicDetails);

		JLabel departmentLabel = new JLabel("Department: ");
		departmentLabel.setFont(baseFont);
		departmentLabel.setBounds(860, 250, 150, 30);
		profile.add(departmentLabel);

		JLabel editLabel = new JLabel("");
		editLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editLabel.setFont(baseFont);
		editLabel.setBounds(589, 531, 400, 30);
		profile.add(editLabel);


		JLabel nameLabelValue = new JLabel(this.teacher.name);
		nameLabelValue.setFont(new Font("Calibri", Font.PLAIN, 20));
		nameLabelValue.setBounds(305, 200, 250, 30);
		profile.add(nameLabelValue);

		JLabel emailLabelValue = new JLabel(this.teacher.email);
		emailLabelValue.setFont(new Font("Calibri", Font.PLAIN, 20));
		emailLabelValue.setBounds(305, 250, 250, 30);
		profile.add(emailLabelValue);

		JLabel grNoLabelValue = new JLabel("11910001");
		grNoLabelValue.setFont(new Font("Calibri", Font.PLAIN, 20));
		grNoLabelValue.setBounds(1015, 200, 250, 30);
		profile.add(grNoLabelValue);

		JLabel departmentLabelValue = new JLabel(this.teacher.department);
		departmentLabelValue.setFont(new Font("Calibri", Font.PLAIN, 20));
		departmentLabelValue.setBounds(1015, 250, 250, 30);
		profile.add(departmentLabelValue);

		JLabel contactLabel = new JLabel("Contact No.: ");
		contactLabel.setFont(baseFont);
		contactLabel.setBounds(165, 300, 150, 30);
		profile.add(contactLabel);

		JLabel contactLabelValue = new JLabel(this.teacher.phone);
		contactLabelValue.setFont(new Font("Dialog", Font.PLAIN, 20));
		contactLabelValue.setBounds(305, 300, 250, 30);
		profile.add(contactLabelValue);

		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		addressLabel.setBounds(165, 350, 100, 30);
		profile.add(addressLabel);

		JLabel addressLabelValue = new JLabel(this.teacher.address);
		addressLabelValue.setFont(new Font("Dialog", Font.PLAIN, 20));
		addressLabelValue.setBounds(305, 350, 250, 30);
		profile.add(addressLabelValue);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		passwordLabel.setBounds(165, 400, 150, 30);
		profile.add(passwordLabel);

		JLabel passwordLabelValue = new JLabel("*".repeat(this.teacher.password.length()));
		passwordLabelValue.setFont(new Font("Dialog", Font.PLAIN, 20));
		passwordLabelValue.setBounds(305, 400, 250, 30);
		profile.add(passwordLabelValue);

		addressField = new JTextField();
		addressField.setFont(new Font("Dialog", Font.PLAIN, 20));
		addressField.setBounds(300, 350, 250, 30);
		profile.add(addressField);
		addressField.setColumns(10);
		addressField.setVisible(false);

		nameField = new JTextField();
		nameField.setFont(new Font("Dialog", Font.PLAIN, 20));
		nameField.setBounds(300, 200, 250, 30);
		profile.add(nameField);
		nameField.setColumns(10);
		nameField.setVisible(false);

		contactField = new JTextField();
		contactField.setFont(new Font("Dialog", Font.PLAIN, 20));
		contactField.setBounds(300, 300, 250, 30);
		profile.add(contactField);
		contactField.setColumns(10);
		contactField.setVisible(false);

		passwordField = new JTextField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 20));
		passwordField.setBounds(305, 400, 250, 26);
		profile.add(passwordField);
		passwordField.setColumns(10);
		passwordField.setVisible(false);

		JButton saveButton = new JButton("Save");
		saveButton.setForeground(Color.BLACK);
		saveButton.setBackground(Color.WHITE);
		saveButton.setFont(baseFont);
		saveButton.setBounds(544, 571, 171, 52);
		saveButton.setVisible(false);
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nameField.setVisible(false);
				contactField.setVisible(false);
				addressField.setVisible(false);
				passwordField.setVisible(false);

				t.name = nameField.getText();
				t.phone = contactField.getText();
				t.address = addressField.getText();
				t.password = passwordField.getText();
				t.update(Main.db);
				nameLabelValue.setText(t.name);
				contactLabelValue.setText(t.phone);
				addressLabelValue.setText(t.address);
				passwordLabelValue.setText("*".repeat(t.password.length()));

				editLabel.setText("Profile saved successfully.");

				nameLabelValue.setVisible(true);
				contactLabelValue.setVisible(true);
				addressLabelValue.setVisible(true);
				passwordLabelValue.setVisible(true);

				saveButton.setVisible(false);
				editButton.setVisible(true);
			}
		});
		profile.add(saveButton);

		editButton = new JButton("Edit Profile");
		editButton.setForeground(Color.BLACK);
		editButton.setBackground(Color.WHITE);
		editButton.setBounds(544, 571, 171, 52);
		editButton.setFont(baseFont);

		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				nameLabelValue.setVisible(false);
				contactLabelValue.setVisible(false);
				addressLabelValue.setVisible(false);
				passwordLabelValue.setVisible(false);

				nameField.setVisible(true);
				nameField.setText(t.name);

				contactField.setVisible(true);
				contactField.setText(t.phone);

				addressField.setVisible(true);
				addressField.setText(t.address);

				passwordField.setVisible(true);
				passwordField.setText(t.password);

				editLabel.setText("Edit your profile");
				editButton.setVisible(false);
				saveButton.setVisible(true);
			}
			});
		profile.add(editButton);

		this.addLogoutButton();
	}

	public ProfileTab(Admin admin) {
		this.admin = admin;

		profile = new JPanel();

		JLabel stdprofilelbl = new JLabel("Admin");
		stdprofilelbl.setBounds(654, 10, 250, 46);
		stdprofilelbl.setFont(titleFont);
		profile.add(stdprofilelbl);

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(165, 200, 100, 30);
		nameLabel.setFont(baseFont);
		profile.add(nameLabel);

		JLabel emailLabel = new JLabel("Email ID:");
		emailLabel.setFont(baseFont);
		emailLabel.setBounds(165, 250, 100, 30);
		profile.add(emailLabel);

		JLabel personalDetailsLabel = new JLabel("Personal Details");
		personalDetailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		personalDetailsLabel.setFont(baseFont);
		personalDetailsLabel.setBounds(250, 137, 200, 30);
		profile.add(personalDetailsLabel);

		JLabel editLabel = new JLabel("");
		editLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editLabel.setFont(baseFont);
		editLabel.setBounds(589, 531, 400, 30);
		profile.add(editLabel);


		JLabel nameLabelValue = new JLabel(this.admin.name);
		nameLabelValue.setFont(new Font("Calibri", Font.PLAIN, 20));
		nameLabelValue.setBounds(305, 200, 250, 30);
		profile.add(nameLabelValue);

		JLabel emailLabelValue = new JLabel(this.admin.email);
		emailLabelValue.setFont(new Font("Calibri", Font.PLAIN, 20));
		emailLabelValue.setBounds(305, 250, 250, 30);
		profile.add(emailLabelValue);

		JLabel contactLabel = new JLabel("Contact No.: ");
		contactLabel.setFont(baseFont);
		contactLabel.setBounds(165, 300, 150, 30);
		profile.add(contactLabel);

		JLabel contactLabelValue = new JLabel(this.admin.phone);
		contactLabelValue.setFont(new Font("Dialog", Font.PLAIN, 20));
		contactLabelValue.setBounds(305, 300, 250, 30);
		profile.add(contactLabelValue);

		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		addressLabel.setBounds(165, 350, 100, 30);
		profile.add(addressLabel);

		JLabel addressLabelValue = new JLabel(this.admin.address);
		addressLabelValue.setFont(new Font("Dialog", Font.PLAIN, 20));
		addressLabelValue.setBounds(305, 350, 250, 30);
		profile.add(addressLabelValue);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		passwordLabel.setBounds(165, 400, 150, 30);
		profile.add(passwordLabel);

		JLabel passwordLabelValue = new JLabel("*".repeat(this.admin.password.length()));
		passwordLabelValue.setFont(new Font("Dialog", Font.PLAIN, 20));
		passwordLabelValue.setBounds(305, 400, 250, 30);
		profile.add(passwordLabelValue);

		addressField = new JTextField();
		addressField.setFont(new Font("Dialog", Font.PLAIN, 20));
		addressField.setBounds(300, 350, 250, 30);
		profile.add(addressField);
		addressField.setColumns(10);
		addressField.setVisible(false);

		nameField = new JTextField();
		nameField.setFont(new Font("Dialog", Font.PLAIN, 20));
		nameField.setBounds(300, 200, 250, 30);
		profile.add(nameField);
		nameField.setColumns(10);
		nameField.setVisible(false);

		contactField = new JTextField();
		contactField.setFont(new Font("Dialog", Font.PLAIN, 20));
		contactField.setBounds(300, 300, 250, 30);
		profile.add(contactField);
		contactField.setColumns(10);
		contactField.setVisible(false);

		passwordField = new JTextField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 20));
		passwordField.setBounds(305, 400, 250, 26);
		profile.add(passwordField);
		passwordField.setColumns(10);
		passwordField.setVisible(false);

		JButton saveButton = new JButton("Save");
		saveButton.setForeground(Color.BLACK);
		saveButton.setBackground(Color.WHITE);
		saveButton.setFont(baseFont);
		saveButton.setBounds(544, 571, 171, 52);
		saveButton.setVisible(false);
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nameField.setVisible(false);
				contactField.setVisible(false);
				addressField.setVisible(false);
				passwordField.setVisible(false);

				admin.name = nameField.getText();
				admin.phone = contactField.getText();
				admin.address = addressField.getText();
				admin.password = passwordField.getText();
				admin.update(Main.db);
				nameLabelValue.setText(admin.name);
				contactLabelValue.setText(admin.phone);
				addressLabelValue.setText(admin.address);
				passwordLabelValue.setText("*".repeat(admin.password.length()));

				editLabel.setText("Profile saved successfully.");

				nameLabelValue.setVisible(true);
				contactLabelValue.setVisible(true);
				addressLabelValue.setVisible(true);
				passwordLabelValue.setVisible(true);

				saveButton.setVisible(false);
				editButton.setVisible(true);
			}
		});
		profile.add(saveButton);

		editButton = new JButton("Edit Profile");
		editButton.setForeground(Color.BLACK);
		editButton.setBackground(Color.WHITE);
		editButton.setBounds(544, 571, 171, 52);
		editButton.setFont(baseFont);

		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				nameLabelValue.setVisible(false);
				contactLabelValue.setVisible(false);
				addressLabelValue.setVisible(false);
				passwordLabelValue.setVisible(false);

				nameField.setVisible(true);
				nameField.setText(admin.name);

				contactField.setVisible(true);
				contactField.setText(admin.phone);

				addressField.setVisible(true);
				addressField.setText(admin.address);

				passwordField.setVisible(true);
				passwordField.setText(admin.password);

				editLabel.setText("Edit your profile");
				editButton.setVisible(false);
				saveButton.setVisible(true);
			}
		});
		profile.add(editButton);

		this.addLogoutButton();
	}

	private void addLogoutButton() {
		JButton logoutButton = new JButton("Logout");
		logoutButton.setForeground(Color.BLACK);
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setFont(baseFont);
		logoutButton.setBounds(733, 571, 171, 52);
		logoutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(logoutButton).dispose();
				LoginGUI loginDashboard = new LoginGUI();
				loginDashboard.setVisible(true);
			}
		});
		profile.add(logoutButton);
	}
}
