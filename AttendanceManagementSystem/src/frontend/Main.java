package frontend;

import javax.swing.JFrame;

import backend.Database;
import classes.*;

// TODO
public class Main {
	public static Database db;

	public static void main(String[] args) {
		String db_url = "***REMOVED***";
		db = new Database(db_url);


		Student.printStudents(db);
		Teacher.printTeachers(db);
		Admin.printAdmins(db);

		LoginGUI loginDashboard = new LoginGUI();
		loginDashboard.setVisible(true);

// 	Test User Table
//		User.dropTable(db);
//		User.createTable(db);
//		User.insertUser(db, "admin@email.com", "admin", "ADMIN");
//		User.insertUser(db, "student.2@email.com", "p", "STUDENT");
//		User.insertUser(db, "student.1@email.com", "t", "STUDENT");
//		User.insertUser(db, "teacher.1@email.com", "t", "TEACHER");

// 	Test Student Table
//		Student.dropTable(db);
//		Student.createTable(db);
//		Student.insert(db, 1, 1, "Student 1", 2, "Computer", 110001, "+91 90000 00001", "MUMBAI, MH");
//		Student.insert(db, 2, 1, "Student 2", 2, "Computer", 110002, "+91 90000 00002", "PUNE, MH");
//		Student.printStudents(db);

// 	Test Teacher Table
//		Teacher.dropTable(db);
//		Teacher.createTable(db);
//		Teacher.insert(db, 4, "Teacher 1", "Computer", 220001, "+91 90000 00003", "PUNE, MH");

// 	Test Admin Table
//		Admin.dropTable(db);
//		Admin.createTable(db);
//		Admin.insert(db, 1, "Admin", "+91 90000 00003", "PUNE, MH");
//		Admin.printAdmins(db);

// 	Test Division Table
//		Division.dropTable(db);
//		Division.createTable(db);
//		Division.insert(db, 2, "CS-A", "Computer");
//		Division.insert(db, 3, "CS-D", "Computer");
//		Division.insert(db, 4, "CH-D", "Chemical");
//		Division.printDivisions(db);

//		for (Subject s : Subject.getTeacherSubjects(db, 3)) {
//			System.out.println(s.name);
//		}

// 	Test Subject Table
//		Subject.dropTable(db);
//		Subject.createTable(db);
//		Subject.insert(db, 1, 1, "CA&OS", "Computer");
//		Subject.insert(db, 1, 1, "DS", "Computer");
//		Subject.printSubjects(db);

// 	Test Attendance Table
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
//		for(Attendance a : Attendance.getStudentAttendance(db, 2)) {
//			a.getInfo();
//		}
//		int[] result = Attendance.getStudentAttendanceResult(db, 1);


// 	Test Notice Table
//		Notice.dropTable(db);
//		Notice.createTable(db);
//		for (int idx=0; idx<1; idx++) {
//			Notice.insert(db, "Notice 2", "Holiday on Jan. 26", 2021, 1, 24);
//			Notice.insert(db, "Notice 3", "Holiday on May. 1", 2021, 4, 30);
//			Notice.insert(db, "Notice 1", "Holiday on Aug. 15", 2020, 8, 13);
//		}
//		Notice.printNotices(db);


// 	Test Student Panel UI
//		Student student = Student.login(db, 2);
//		student.printAcademicInfo();
//		StudentDashboard studentDashboard = new StudentDashboard(student);
//		studentDashboard.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		studentDashboard.setVisible(true);

// 	Test Teacher Panel UI
//		Teacher teacher = Teacher.login(db, 4);
// 		TeacherDashboard teacherDashboard = new TeacherDashboard(teacher);
// 		teacherDashboard.setExtendedState(JFrame.MAXIMIZED_BOTH);
// 		teacherDashboard.setVisible(true);

// 	Test Admin Panel UI
//		Admin admin = Admin.login(db, 1);
//		AdminDashboard adminDashboard = new AdminDashboard(admin);
//		adminDashboard.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		adminDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		adminDashboard.setVisible(true);
	}
}
