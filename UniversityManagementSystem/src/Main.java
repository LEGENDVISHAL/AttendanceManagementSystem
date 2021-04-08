import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		LoginGUI login = new LoginGUI();
		login.setBounds(0, 0, 840, 570);
		login.setResizable(false);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setVisible(true);
		
		
//		StudentDashboard sd = new StudentDashboard();
//		sd.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		sd.setVisible(true);
		
	}

}
