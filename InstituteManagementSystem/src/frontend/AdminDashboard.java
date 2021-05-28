package frontend;

import javax.swing.*;

import classes.Admin;
import classes.Notice;
import frontend.tabs.AddDivisionTab;
import frontend.tabs.AddStudentTab;
import frontend.tabs.AddSubjectTab;
import frontend.tabs.AddTeacherTab;
import frontend.tabs.NoticeTab;
import frontend.tabs.ProfileTab;

import java.awt.BorderLayout;
import java.util.Calendar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminDashboard extends JFrame {

	private static final long serialVersionUID = -3537973360610605294L;
	private JPanel profileTab, addStudentTab, addTeacherTab, addDivisionTab, addSubjectTab, addNoticeTab, noticeTab;
	private JTextField titleField;
	private JTextPane contentField;
	
	private NoticeTab notice;
		
	public AdminDashboard(Admin admin) {
		JTabbedPane adminPane = new JTabbedPane(JTabbedPane.TOP);
		addNoticeTab = new JPanel();
		noticeTab = new JPanel();
		
		// Profile panel
		ProfileTab profile = new ProfileTab(admin);
		profileTab = profile.profile;
		adminPane.add("Profile", profileTab);
		profileTab.setLayout(null);
		
		// Add Student panel
		AddStudentTab addStudent = new AddStudentTab();
		addStudentTab = addStudent.addStudentTab;
		adminPane.add("Add Student", addStudentTab);
		
		// Add Teacher panel
		AddTeacherTab addTeacher = new AddTeacherTab();
		addTeacherTab = addTeacher.addTeacherTab;
		adminPane.add("Add Teacher", addTeacherTab);
		
		// Add Division panel
		AddDivisionTab addDivision = new AddDivisionTab();
		addDivisionTab = addDivision.addDivisionTab;
		adminPane.add("Add Division", addDivisionTab);
		
		// Add Subject panel
		AddSubjectTab addSubject = new AddSubjectTab();
		addSubjectTab = addSubject.addSubjectTab;
		adminPane.add("Add Subject", addSubjectTab);
		
		// Add Notice
		adminPane.add("Add Notice", addNoticeTab);
		addNoticeTab.setLayout(null);
		
		titleField = new JTextField();
		titleField.setFont(new Font("Dialog", Font.BOLD, 32));
		titleField.setBounds(200, 62, 650, 40);
		addNoticeTab.add(titleField);
		titleField.setColumns(10);
		
		contentField = new JTextPane();
		contentField.setFont(new Font("Calibri", Font.PLAIN, 20));
		contentField.setBounds(100, 160, 750, 500);
		contentField.setAlignmentX(CENTER_ALIGNMENT);
		addNoticeTab.add(contentField);
		
		JButton addNoticeButton = new JButton("Add Notice");
		addNoticeButton.setFont(new Font("Calibri", Font.BOLD, 20));
		addNoticeButton.setBounds(700, 680, 150, 50);
		addNoticeTab.add(addNoticeButton);
		
		JLabel titleLabel = new JLabel("Title:");
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 28));
		titleLabel.setBounds(100, 62, 100, 40);
		addNoticeTab.add(titleLabel);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblContent.setBounds(100, 118, 100, 40);
		addNoticeTab.add(lblContent);
		
		
		// Notice Board
		notice = new NoticeTab(true);	
		noticeTab = notice.viewnotice;
		adminPane.add("Notice", noticeTab);
		noticeTab.setLayout(null);
		
		// Action Listeners
		addNoticeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = titleField.getText();
				String content = contentField.getText();
				contentField.setText("");
				Calendar cal = Calendar.getInstance();
				Notice.insert(Main.db, title, content, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
				notice.updateNotices();
//				notice = new NoticeTab(true);
			}
		});
	
		getContentPane().add(adminPane, BorderLayout.CENTER);
	}
}