package application;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import user.User;

public class InformationUI extends JFrame implements Runnable {

	private String name, gender, activity;
	private int age;

	private JFrame frame;
	private JLabel ageLabel, nameLabel, genderLabel, activityLabel;
	private JTextField nameTxt, ageTxt;
	private JComboBox<String> genderBox, activityBox;
	private JButton enterBtn, backBtn;
	
	private User user;
	
	public InformationUI() {
		frame = this;
		frame.setTitle("Basic Information");
		frame.setSize(800, 450);
		initComponents();
	}
	
	private void initComponents() {
		ageLabel = new JLabel("Age: ");
		nameLabel = new JLabel("Name: ");
		genderLabel = new JLabel("Gender: ");
		activityLabel = new JLabel("Activity: ");
		nameTxt = new JTextField(10);
		ageTxt = new JTextField(5);
		enterBtn = new JButton("ENTER");
		// Not use yet!
		backBtn = new JButton("BACK");
		
		String[] genderArr = {"Male", "Female"};
		String[] activityArr = {"Sedentary", "Moderately Active", "Active"};
		
		genderBox = new JComboBox(genderArr);
		activityBox = new JComboBox(activityArr);
		
		enterBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				name = nameTxt.getText();
				age = Integer.parseInt(ageTxt.getText());
				gender = genderBox.getSelectedItem() + "";
				activity = activityBox.getSelectedItem() + "";
				
				//Create User
				user = new User(name, gender, activity, age);
				PickTypeUI ui = new PickTypeUI(user);
				ui.run();
				frame.dispose();
			}
		});
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel bigPanel = new JPanel();
		
		panel1.add(nameLabel);
		panel1.add(nameTxt);
		panel2.add(ageLabel);
		panel2.add(ageTxt);
		panel3.add(genderLabel);
		panel3.add(genderBox);
		panel4.add(activityLabel);
		panel4.add(activityBox);
		panel5.add(enterBtn);
		
		bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));
		bigPanel.add(panel1);
		bigPanel.add(panel2);
		bigPanel.add(panel3);
		bigPanel.add(panel4);
		bigPanel.add(panel5);
		frame.add(bigPanel);
	}
	
	@Override
	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
