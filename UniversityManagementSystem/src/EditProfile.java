import java.awt.*;
import javax.swing.*;

public class EditProfile extends JFrame{
	public EditProfile() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Profile");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		lblNewLabel.setBounds(183, 10, 123, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 60, 79, 20);
		panel.add(lblNewLabel_1);
	}
}
