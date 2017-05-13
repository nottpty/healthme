package application;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InformationUI extends JFrame implements Runnable {

	private String name, gender, activity;
	private int age;

	private JLabel ageLabel, nameLabel, genderLabel, activityLabel;
	private JTextField nameTxt, ageTxt, genderTxt, activityTxt;
	
	public InformationUI() {
		this.setTitle("Basic Information");
		this.setSize(800, 450);
		initComponents();
	}
	
	public void initComponents() {
		
	}
	
	@Override
	public void run() {
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
