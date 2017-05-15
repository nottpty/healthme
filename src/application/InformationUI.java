package application;

import java.awt.Color;
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
import java.awt.Font;

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
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ageLabel.setBounds(105, 115, 63, 75);
		nameLabel = new JLabel("Name: ");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLabel.setBounds(106, 30, 115, 75);
		genderLabel = new JLabel("Gender: ");
		genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		genderLabel.setBounds(344, 102, 100, 100);
		activityLabel = new JLabel("Activity: ");
		activityLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		activityLabel.setBounds(105, 201, 100, 100);
		nameTxt = new JTextField(10);
		nameTxt.setBounds(191, 46, 363, 43);
		ageTxt = new JTextField(5);
		ageTxt.setBounds(191, 135, 113, 43);
		enterBtn = new JButton("ENTER");
		enterBtn.setBounds(555, 329, 100, 37);
		
		enterBtn.setBackground(new Color(59, 89, 182));
        enterBtn.setForeground(Color.WHITE);
        enterBtn.setFocusPainted(false);
		// Not use yet!
		backBtn = new JButton("BACK");
		backBtn.setBounds(424, 329, 100, 37);
		backBtn.setBackground(new Color(59, 89, 182));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFocusPainted(false);
		
		String[] genderArr = {"Male", "Female"};
		String[] activityArr = {"Sedentary", "Moderately Active", "Active"};
		
		genderBox = new JComboBox(genderArr);
		genderBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		genderBox.setBounds(454, 135, 100, 43);
		activityBox = new JComboBox(activityArr);
		activityBox.setBounds(191, 234, 113, 43);
		
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
		getContentPane().setLayout(null);
		
		frame.getContentPane().add(activityBox);
		frame.getContentPane().add(activityLabel);
		frame.getContentPane().add(ageLabel);
		frame.getContentPane().add(ageTxt);
		frame.getContentPane().add(backBtn);
		frame.getContentPane().add(enterBtn);
		frame.getContentPane().add(genderBox);
		frame.getContentPane().add(genderLabel);
		frame.getContentPane().add(nameLabel);
		frame.getContentPane().add(nameTxt);
	}
	
	@Override
	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
