package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import user.User;
import java.awt.Font;
import java.awt.Toolkit;

import java.sql.*;

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
	private int age, weight, height;
	private JLabel ageLabel, nameLabel, genderLabel, activityLabel, passwordLabel, weightLabel, heightLabel;
	private JTextField nameTxt, ageTxt, weightTxt, heightTxt;
	private JComboBox<String> genderBox, activityBox;
	private JButton enterBtn, backBtn;
	private JPasswordField passwordTxt;

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
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}

	/**
	 * To initial all components in user interface(UI).
	 */
	private void initComponents() {
		ageLabel = new JLabel("Age: ");
		nameLabel = new JLabel("Name: ");
		genderLabel = new JLabel("Gender: ");
		activityLabel = new JLabel("Activity: ");
		weightLabel = new JLabel("Weight: ");
		heightLabel = new JLabel("Height: ");
		passwordLabel = new JLabel("Password: ");

		String[] genderArr = { "Male", "Female" };
		String[] activityArr = { "Sedentary", "Lightly Active", "Moderately Active", "Very Active",
				"Extremely Active" };
		genderBox = new JComboBox<String>(genderArr);
		activityBox = new JComboBox<String>(activityArr);
		passwordTxt = new JPasswordField(15);
		weightTxt = new JTextField(5);
		heightTxt = new JTextField(5);
		nameTxt = new JTextField(10);
		ageTxt = new JTextField(5);
		enterBtn = new JButton("ENTER");

		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		activityLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		genderBox.setFont(new Font("Tahoma", Font.PLAIN, 15));

		enterBtn.setBackground(new Color(59, 89, 182));
		enterBtn.setForeground(Color.WHITE);
		enterBtn.setFocusPainted(false);
		enterBtn.setOpaque(true);
		enterBtn.setBorderPainted(false);
		// Not use yet!
		backBtn = new JButton("BACK");
		backBtn.setBackground(new Color(59, 89, 182));
		backBtn.setForeground(Color.WHITE);
		backBtn.setFocusPainted(false);
		backBtn.setOpaque(true);
		backBtn.setBorderPainted(false);

		enterBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				name = nameTxt.getText();
				age = Integer.parseInt(ageTxt.getText());
				gender = genderBox.getSelectedItem() + "";
				activity = activityBox.getSelectedItem() + "";
				weight = Integer.parseInt(weightTxt.getText());
				height = Integer.parseInt(heightTxt.getText());

				// Create User
				user = new User(name, gender, age, weight, height, activity);
				insertToDatabase();
				user.caloriesNeeded();
				PickTypeUI ui = new PickTypeUI(user);
				ui.run();
				dispose();
			}
		});
		
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginUI loginUI = new LoginUI();
				loginUI.run();
				dispose();
			}
		});

		JPanel panel0 = new JPanel();
		panel0.setBackground(Color.WHITE);
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.WHITE);
		JPanel panel5 = new JPanel();
		panel5.setBackground(Color.WHITE);
		JPanel panel6 = new JPanel();
		panel6.setBackground(Color.WHITE);
		JPanel panel7 = new JPanel();
		panel7.setBackground(Color.WHITE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		panel0.add(nameLabel);
		panel0.add(nameTxt);
		panel1.add(passwordLabel);
		panel1.add(passwordTxt);
		panel2.add(weightLabel);
		panel2.add(weightTxt);
		panel3.add(heightLabel);
		panel3.add(heightTxt);
		panel4.add(ageLabel);
		panel4.add(ageTxt);
		panel5.add(genderLabel);
		panel5.add(genderBox);
		panel6.add(activityLabel);
		panel6.add(activityBox);
		panel7.add(backBtn);
		panel7.add(enterBtn);

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(panel0);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);
		panel.add(panel7);
		this.add(panel);
	}

	/**
	 * To show user interface of this frame.
	 */
	public void run() {
		this.setVisible(true);
	}

	/**
	 * Insert information of user to database.
	 */
	public void insertToDatabase() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:user.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "INSERT INTO USER (NAME,PASSWORD,GENDER,WEIGHT,HEIGHT,ACTIVITY,AGE) " + "VALUES (" + '\''
					+ user.getName().trim() + '\'' + "," + '\'' + passwordTxt.getText() + '\'' + "," + '\'' + user.getGender()
					+ '\'' + "," + '\'' + user.getWeight() + '\'' + "," + '\'' + user.getHeight() + '\'' + "," + '\''
					+ user.getActivity() + '\'' + "," + '\'' + user.getAge() + '\'' + ");";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		System.out.println("Records created successfully");
	}

}
