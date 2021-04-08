
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StudentDashboard extends JFrame{
	
	private JPanel profile;
	private JPanel fees;
	private JPanel attendance;
	private JPanel registration;
	private JPanel editProfile;
	private Font titleFont = new Font("Calibri", Font.BOLD, 30);
	private Font baseFont = new Font("Calibri", Font.BOLD, 20);
	private JButton editbutton;
	private JTextField txtSuratGujrat;
	private JTextField textField_1;
	
	public StudentDashboard() {
		
		JTabbedPane studmenu = new JTabbedPane(JTabbedPane.TOP);
		fees = new JPanel();
		attendance = new JPanel();
		registration = new JPanel();
		profile = new JPanel();
		
		//Profile panel
		
		JLabel stdprofilelbl = new JLabel("Student Profile");
		stdprofilelbl.setBounds(654, 10, 196, 46);
		stdprofilelbl.setFont(titleFont);
		profile.add(stdprofilelbl);
		
		JLabel namelbl = new JLabel("Name : ");
		namelbl.setBounds(165, 199, 69, 30);
		namelbl.setFont(baseFont);
		profile.add(namelbl);
		
		studmenu.add("Profile",profile);
		profile.setLayout(null);
		
		JLabel lblDob = new JLabel("DOB : ");
		lblDob.setFont(new Font("Calibri", Font.BOLD, 20));
		lblDob.setBounds(165, 250, 69, 30);
		profile.add(lblDob);
		
		JLabel lblEmailId = new JLabel("Email ID : ");
		lblEmailId.setFont(new Font("Calibri", Font.BOLD, 20));
		lblEmailId.setBounds(165, 302, 105, 30);
		profile.add(lblEmailId);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAddress.setBounds(165, 403, 105, 30);
		profile.add(lblAddress);
		
		JLabel lblPersonalDetails = new JLabel("Personal Details");
		lblPersonalDetails.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPersonalDetails.setBounds(197, 137, 153, 30);
		profile.add(lblPersonalDetails);
		
		JLabel lblGrNo = new JLabel("GR no. : ");
		lblGrNo.setFont(new Font("Calibri", Font.BOLD, 20));
		lblGrNo.setBounds(860, 199, 86, 30);
		profile.add(lblGrNo);
		
		JLabel lblAcademicDetails = new JLabel("Academic Details");
		lblAcademicDetails.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAcademicDetails.setBounds(906, 137, 153, 30);
		profile.add(lblAcademicDetails);
		
		JLabel lblDepartment = new JLabel("Department : ");
		lblDepartment.setFont(new Font("Calibri", Font.BOLD, 20));
		lblDepartment.setBounds(860, 250, 125, 30);
		profile.add(lblDepartment);
		
		JLabel lblYear = new JLabel("Year : ");
		lblYear.setFont(new Font("Calibri", Font.BOLD, 20));
		lblYear.setBounds(863, 302, 69, 30);
		profile.add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester : ");
		lblSemester.setFont(new Font("Calibri", Font.BOLD, 20));
		lblSemester.setBounds(860, 357, 105, 30);
		profile.add(lblSemester);
		
		JLabel editemail_1 = new JLabel("");
		editemail_1.setHorizontalAlignment(SwingConstants.CENTER);
		editemail_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		editemail_1.setBounds(589, 531, 273, 30);
		profile.add(editemail_1);
		
		editbutton = new JButton("Edit Profile");
		editbutton.setBounds(544, 571, 171, 52);
		editbutton.setFont(baseFont);
		editbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
//				EditProfile editprofile = new EditProfile();
//				editprofile.setLocationRelativeTo(null);
//				editprofile.setBounds(500,100,500,600);
//				editprofile.setResizable(false);
//				
//				editprofile.setVisible(true);
				txtSuratGujrat.setVisible(true);
				textField_1.setVisible(true);
				editemail_1.setText("Edit your profile");
				
				
				
				
				
			}
			});
		profile.add(editbutton);
		
		JLabel editname = new JLabel("Utsav Patel");
		editname.setFont(new Font("Calibri", Font.PLAIN, 20));
		editname.setBounds(305, 199, 273, 30);
		profile.add(editname);
		
		JLabel editdob = new JLabel("03 / 11 / 2001 ");
		editdob.setFont(new Font("Calibri", Font.PLAIN, 20));
		editdob.setBounds(305, 250, 273, 30);
		profile.add(editdob);
		
		JLabel editemail = new JLabel("utsav.patel19@vit.edu");
		editemail.setFont(new Font("Calibri", Font.PLAIN, 20));
		editemail.setBounds(305, 302, 273, 30);
		profile.add(editemail);
		
		JLabel editgrno = new JLabel("11910127");
		editgrno.setFont(new Font("Calibri", Font.PLAIN, 20));
		editgrno.setBounds(1015, 199, 251, 30);
		profile.add(editgrno);
		
		JLabel editdept = new JLabel("Computer Science");
		editdept.setFont(new Font("Calibri", Font.PLAIN, 20));
		editdept.setBounds(1015, 250, 251, 30);
		profile.add(editdept);
		
		JLabel edityear = new JLabel("2nd year");
		edityear.setFont(new Font("Calibri", Font.PLAIN, 20));
		edityear.setBounds(1015, 302, 251, 30);
		profile.add(edityear);
		
		JLabel editsem = new JLabel("4");
		editsem.setFont(new Font("Calibri", Font.PLAIN, 20));
		editsem.setBounds(1015, 357, 251, 30);
		profile.add(editsem);
		
		txtSuratGujrat = new JTextField();
		txtSuratGujrat.setText("Surat, Gujrat - 411033");
		txtSuratGujrat.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtSuratGujrat.setBounds(305, 403, 241, 100);
		txtSuratGujrat.setVisible(false);
		profile.add(txtSuratGujrat);
		
		JLabel lblContactNo = new JLabel("Contact No. : ");
		lblContactNo.setFont(new Font("Calibri", Font.BOLD, 20));
		lblContactNo.setBounds(165, 357, 112, 30);
		profile.add(lblContactNo);
		
		textField_1 = new JTextField();
		textField_1.setText("7028832326");
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		textField_1.setBounds(305, 351, 196, 30);
		textField_1.setVisible(false);
		profile.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNull = new JLabel("NULL");
		lblNull.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNull.setBounds(305, 351, 273, 30);
		profile.add(lblNull);
		
		JLabel lblNull_1 = new JLabel("NULL");
		lblNull_1.setVerticalAlignment(SwingConstants.TOP);
		lblNull_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNull_1.setBounds(305, 403, 273, 100);
		profile.add(lblNull_1);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Calibri", Font.BOLD, 20));
		btnSave.setBounds(733, 571, 171, 52);
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtSuratGujrat.setVisible(false);
				textField_1.setVisible(false);
				lblNull_1.setText(txtSuratGujrat.getText());
				lblNull.setText(textField_1.getText());
				editemail_1.setText("Profile saved successfully.");
				
			}
			
			
		});
		profile.add(btnSave);
		
		


		//Fees panel
		//Attendance panel
		//Registration panel

		studmenu.add("Fees",fees);
		studmenu.add("Attendance",attendance);
		attendance.setLayout(new GridLayout(2,4,10,10));
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		attendance.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		attendance.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		attendance.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		attendance.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		attendance.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		attendance.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		attendance.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		attendance.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		attendance.add(lblNewLabel);
		studmenu.add("Registration", registration);
		getContentPane().add(studmenu, BorderLayout.CENTER);
		
	}
}
