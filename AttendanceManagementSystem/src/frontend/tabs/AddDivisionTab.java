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
import classes.Division;
import frontend.Main;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddDivisionTab {
	
	public JPanel addDivisionTab;

	private JTextField nameField;
	private JTextField teacherField;
	
	private Font titleFont = new Font("Calibri", Font.BOLD, 30);
	private Font baseFont = new Font("Calibri", Font.BOLD, 20);
	
	public AddDivisionTab() {		
		addDivisionTab = new JPanel();
		addDivisionTab.setLayout(null);
		
		JLabel titleLabel = new JLabel("Add Division");
		titleLabel.setBounds(654, 10, 250, 46);
		titleLabel.setFont(titleFont);
		addDivisionTab.add(titleLabel);
		
		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(165, 200, 100, 30);
		nameLabel.setFont(baseFont);
		addDivisionTab.add(nameLabel);
		
		
		JLabel personalDetailsLabel = new JLabel("Division Details");
		personalDetailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		personalDetailsLabel.setFont(baseFont);
		personalDetailsLabel.setBounds(250, 137, 200, 30);
		addDivisionTab.add(personalDetailsLabel);
		
		JLabel departmentLabel = new JLabel("Department: ");
		departmentLabel.setFont(baseFont);
		departmentLabel.setBounds(165, 250, 150, 30);
		addDivisionTab.add(departmentLabel);
		
		JLabel editLabel = new JLabel("");
		editLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editLabel.setFont(baseFont);
		editLabel.setBounds(589, 531, 400, 30);
		addDivisionTab.add(editLabel);
		
		JLabel divisionLabel = new JLabel("Teacher ID: ");
		divisionLabel.setFont(baseFont);
		divisionLabel.setBounds(165, 300, 150, 30);
		addDivisionTab.add(divisionLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Dialog", Font.PLAIN, 20));
		nameField.setBounds(300, 200, 250, 30);
		addDivisionTab.add(nameField);
		nameField.setColumns(10);
		
		teacherField = new JTextField();
		teacherField.setFont(new Font("Dialog", Font.PLAIN, 20));
		teacherField.setColumns(10);
		teacherField.setBounds(300, 300, 250, 30);
		addDivisionTab.add(teacherField);
		
		JComboBox<String> departmentDropdown = new JComboBox<String>();
		departmentDropdown.setModel(new DefaultComboBoxModel<String>(new String[] {"Computer", "Mechanical", "Chemical", "Instrumentation"}));
		departmentDropdown.setFont(new Font("Dialog", Font.PLAIN, 20));
		departmentDropdown.setBounds(300, 250, 250, 30);
		addDivisionTab.add(departmentDropdown);
		
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

				Division.insert(Main.db, teacherId, name, department);
				
				editLabel.setText("Division added successfully.");
			}
		});
		addDivisionTab.add(saveButton);
	}
}
