import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginGUI extends JFrame{
	
	private Font titleFont = new Font("Calibri", Font.BOLD, 30);
	private Font baseFont = new Font("Calibri", Font.BOLD, 20);
	private JTextField userinput;
	private JPasswordField passwordinput;
	
	
	public LoginGUI() {
		
		JPanel loginpanel = new JPanel();
		getContentPane().add(loginpanel, BorderLayout.CENTER);
		loginpanel.setLayout(null);
		
		JLabel title = new JLabel("Institute Management System");
		title.setFont(titleFont);
		title.setBounds(223, 49, 380, 45);
		loginpanel.add(title);
		
		JLabel loginas = new JLabel("Login As : ");
		loginas.setBounds(223, 161, 95, 32);
		loginas.setFont(baseFont);
		
		loginpanel.add(loginas);
		
		JComboBox roleSelector = new JComboBox();
		roleSelector.setModel(new DefaultComboBoxModel(new String[] {"Student", "Teacher", "Admin"}));
		roleSelector.setBounds(422, 162, 164, 28);
		loginpanel.add(roleSelector);
		
		JLabel username = new JLabel("Username : ");
		username.setFont(new Font("Calibri", Font.BOLD, 20));
		username.setBounds(223, 221, 108, 32);
		loginpanel.add(username);
		
		JLabel password = new JLabel("Password : ");
		password.setFont(new Font("Calibri", Font.BOLD, 20));
		password.setBounds(223, 279, 108, 32);
		loginpanel.add(password);
		
		userinput = new JTextField();
		userinput.setBounds(422, 221, 164, 25);
		loginpanel.add(userinput);
		userinput.setColumns(10);
		
		passwordinput = new JPasswordField();
		passwordinput.setBounds(422, 282, 164, 25);
		loginpanel.add(passwordinput);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(223, 364, 155, 45);
		loginButton.setFont(baseFont);
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentDashboard stud = new StudentDashboard();
				stud.setExtendedState(JFrame.MAXIMIZED_BOTH);
				stud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				stud.setVisible(true);
				
			}
			
		});
		
		loginpanel.add(loginButton);
		
		JButton forgotbutton = new JButton("Forgot Password?");
		forgotbutton.setBounds(405, 364, 181, 45);
		forgotbutton.setFont(baseFont);
		loginpanel.add(forgotbutton);
	}
}





