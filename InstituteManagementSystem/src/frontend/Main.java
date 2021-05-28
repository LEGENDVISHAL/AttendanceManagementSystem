package frontend;

import javax.swing.JFrame;

import backend.Database;
import classes.*;

// TODO 
public class Main {
	public static Database db;

	public static void main(String[] args) {
		db = new Database("***REMOVED***");

		
			
//		Student.createTable(db);
//		Teacher.createTable(db);
//		User.createTable(db);
		
//		Attendance.dropTable(db);
//		Attendance.createTable(db);
//		Attendance.insert(db, 1, 1, 2020, 5, 7, 11, true);
//		Attendance.insert(db, 1, 1, 2020, 5, 7, 12, true);
//		Attendance.insert(db, 1, 2, 2020, 5, 8, 11, false);
//		Attendance.insert(db, 1, 2, 2020, 5, 8, 12, false);
		
//		Attendance.insert(db, 2, 1, 2020, 5, 7, 11, true);
//		Attendance.insert(db, 2, 1, 2020, 5, 7, 12, true);
		
//		Attendance.insert(db, 3, 1, 2020, 5, 7, 11, false);
//		Attendance.insert(db, 3, 1, 2020, 5, 7, 12, true);
//		Attendance.printAttendance(db);
//		Student.printStudents(db);
//		Teacher.printTeachers(db);
//		Subject.printSubjects(db);
		
//		
//		for(Attendance a : Attendance.getStudentAttendance(db, 2)) {
//			a.getInfo();
//		}
//		int[] result = Attendance.getStudentAttendanceResult(db, 1);
//		System.out.println(result[0] + " " + result[1]);
		
//		User.insertUser(db, "admin@vit.edu", "admin", "ADMIN");
//		User.insertUser(db, "utsav@vit.edu", "p", "STUDENT");
//		User.insertUser(db, "vishal@vit.edu", "t", "STUDENT");
//		User.insertUser(db, "ritesh@vit.edu", "t", "TEACHER");
		
		User.printUsers(db);
		Student.printStudents(db);
		Teacher.printTeachers(db);
		
		
		
//		Create Students
//		Student.dropTable(db);
//		Student.createTable(db);
//		Student.insert(db, 1, 1, "Utsav Patel", 2, "Computer", 11910001, "UTSAV PHONE", "GUJARAT");
//		Student.insert(db, 2, 1, "Vishal Thoke", 2, "Computer", 11910002, "VISHAL PHONE", "GUJARAT");

		
//		Create Teachers
//		Teacher.dropTable(db);
//		Teacher.createTable(db);
//		Teacher.insert(db, 4, "Ritesh Thakur", "Computer", 1101001, "RITESH PHONE", "PUNE");
		
//		Create Admins
//		Admin.dropTable(db);
//		Admin.createTable(db);
//		Admin.insert(db, 1, "Admin", "RITESH PHONE", "PUNE");
//		Admin.printAdmins(db);


// 		Create Notices
//		Notice.dropTable(db);
//		Notice.createTable(db);
//		for (int idx=0; idx<1; idx++) {
//			Notice.insert(db, "Notice 2", "Holiday on Jan. 26", 2021, 1, 24);
//			Notice.insert(db, "Notice 3", "Holiday on May. 1", 2021, 4, 30);
//			Notice.insert(db, "Notice 1", "Holiday on Aug. 15", 2020, 8, 13);
//		}
//		Notice.printNotices(db);
		
//		LoginGUI loginDashboard = new LoginGUI();
//		loginDashboard.setVisible(true);
				
//		Student student = Student.login(db, 2);
//		student.printAcademicInfo();
//		StudentDashboard studentDashboard = new StudentDashboard(student);
//		studentDashboard.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		studentDashboard.setVisible(true);
		
		Teacher teacher = Teacher.login(db, 4);
		TeacherDashboard teacherDashboard = new TeacherDashboard(teacher);
		teacherDashboard.setExtendedState(JFrame.MAXIMIZED_BOTH);
		teacherDashboard.setVisible(true);
		
//		Admin admin = Admin.login(db, 1);
//		AdminDashboard adminDashboard = new AdminDashboard(admin);
//		adminDashboard.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		adminDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		adminDashboard.setVisible(true);	
		
//		Division.printDivisions(db);
//		Subject.printSubjects(db);
//		Student.printStudents(db);
		
//		Division.dropTable(db);
//		Division.createTable(db);
//		Division.insert(db, 2, "CS-A", "Computer");
//		Division.insert(db, 3, "CS-D", "Computer");
//		Division.insert(db, 4, "CH-D", "Chemical");
//		Division.printDivisions(db);
		
//		for (Subject s : Subject.getTeacherSubjects(db, 3)) {
//			System.out.println(s.name);
//		}
		
//		Subject.dropTable(db);
//		Subject.createTable(db);
//		Subject.insert(db, 1, 1, "CA&OS", "Computer");
//		Subject.insert(db, 1, 1, "DS", "Computer");
		Subject.printSubjects(db);
	}
}
