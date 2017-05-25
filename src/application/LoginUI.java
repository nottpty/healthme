package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import user.User;

import java.sql.*;

public class LoginUI extends JFrame {
	private JLabel loginLabel, passwordLabel, titleLabel;
	private JTextField nameTextfield;
	private JPasswordField passwordTextfield;
	private JButton loginButton, registerButton;
	private User user;

	public LoginUI() {
		this.setTitle("HealthMe Login");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}

	public void initComponents() {
		this.setLayout(new GridLayout(4,2));
		titleLabel = new JLabel("HealthMe", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
//		titleLabel.setBounds(0, 0, 784, 242);
		loginLabel = new JLabel("Your name: ");
		nameTextfield = new JTextField(15);
		passwordLabel = new JLabel("  Password: ");
		passwordTextfield = new JPasswordField(15);
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connectDatabase();
			}
		});
		registerButton = new JButton("Register now!!");
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InformationUI informationUI = new InformationUI();
				informationUI.run();
				dispose();
			}
		});
		
		Panel panel0 = new Panel(new FlowLayout());
		panel0.setBackground(Color.WHITE);
		Panel panel1 = new Panel(new FlowLayout());
		panel1.setBackground(Color.WHITE);
		Panel panel2 = new Panel(new FlowLayout());
		panel2.setBackground(Color.WHITE);
		Panel panel3 = new Panel(new FlowLayout());
		panel3.setBackground(Color.WHITE);
		panel0.add(titleLabel);
		panel1.add(loginLabel);
		panel1.add(nameTextfield);
		panel2.add(passwordLabel);
		panel2.add(passwordTextfield);
		panel3.add(loginButton);
		panel3.add(registerButton);
		this.add(panel0);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.pack();
	}

	public void connectDatabase() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:user.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER;");
			while (rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String activity = rs.getString("activity");
				int weight = rs.getInt("weight");
				int height = rs.getInt("height");
				int age = rs.getInt("age");
				System.out.println("NAME = " + name);
				System.out.println("PASSWORD = " + password);
				if (passwordTextfield.getText().equals(password) && name.equals(nameTextfield.getText())) {
					user = new User(name, gender, age, weight, height, activity);
					user.caloriesNeeded();
					PickTypeUI ui = new PickTypeUI(user);
					ui.run();
					dispose();
					System.out.println("Login successfully");
					break;
				}
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	public void run() {
		this.setVisible(true);
	}
}
