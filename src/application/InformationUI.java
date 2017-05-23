package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import user.User;
import java.awt.Font;
import java.awt.Toolkit;

/**
 * A page that need user to fill their basic information.
 * 
 * @author Narut Poovorakit, Patinya Yongyai
 * 
 * @version 20.05.2017
 *
 */
public class InformationUI extends JFrame {

	private String name, gender, activity;
	private int age;
	private JLabel ageLabel, nameLabel, genderLabel, activityLabel;
	private JTextField nameTxt, ageTxt;
	private JComboBox<String> genderBox, activityBox;
	private JButton enterBtn, backBtn;
	private Connection connect = null;
	private Statement s = null;
	
	private User user;
	
	/**
	 * Create page
	 */
	public InformationUI() {
		this.setTitle("Basic Information");
		this.setSize(800, 450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
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
        enterBtn.setOpaque(true);
        enterBtn.setBorderPainted(false);
		// Not use yet!
		backBtn = new JButton("BACK");
		backBtn.setBounds(424, 329, 100, 37);
		backBtn.setBackground(new Color(59, 89, 182));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFocusPainted(false);
        backBtn.setOpaque(true);
        backBtn.setBorderPainted(false);
		
		String[] genderArr = {"Male", "Female"};
		String[] activityArr = {"Sedentary", "Moderately Active", "Active"};
		
		genderBox = new JComboBox<String>(genderArr);
		genderBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		genderBox.setBounds(454, 135, 100, 43);
		activityBox = new JComboBox<String>(activityArr);
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
				insertToDatabase(user);
				user.caloriesNeeded();
				PickTypeUI ui = new PickTypeUI(user);
				ui.run();
				dispose();
			}
		});
		getContentPane().setLayout(null);
		
		this.getContentPane().add(activityBox);
		this.getContentPane().add(activityLabel);
		this.getContentPane().add(ageLabel);
		this.getContentPane().add(ageTxt);
		this.getContentPane().add(backBtn);
		this.getContentPane().add(enterBtn);
		this.getContentPane().add(genderBox);
		this.getContentPane().add(genderLabel);
		this.getContentPane().add(nameLabel);
		this.getContentPane().add(nameTxt);
	}
	
	public void run() {
		this.setVisible(true);
	}
	
	public void insertToDatabase(User user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect =  DriverManager.getConnection("jdbc:mysql://localhost/HealthMe" +
					"?autoReconnect=true&useSSL=false&user=root&password=null");
			if(connect != null){
				System.out.println("Database Connected.");
			} else {
				System.out.println("Database Connect Failed.");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Close
		try {
			if(connect != null){
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			
//			s = connect.createStatement();
//			
//			String sql = "INSERT INTO user " +
//					"(name,gender,age) " + 
//					"VALUES ("+'\''+user.getName()+'\''+","+'\''+user.getGender()+'\''+","+'\''+user.getAge()+'\''+") ";
//			 s.execute(sql);
//			
//			 System.out.println("Record Inserted Successfully");
//			 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//
//		try {
//			if(s != null) {
//				s.close();
//				connect.close();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
	}

}
