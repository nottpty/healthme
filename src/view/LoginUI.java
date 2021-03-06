package view;

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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import user.User;

import java.sql.*;

/**
 * Login page check account and password of user to login. If user doesn't has
 * account, user can register account by click at register button.
 * 
 * @author Patinya Yongyai
 *
 */
public class LoginUI extends JFrame {
	private JLabel loginLabel, passwordLabel, titleLabel;
	private JTextField nameTextfield;
	private JPasswordField passwordTextfield;
	private JButton loginButton, registerButton;
	private User user;

	/**
	 * To create user interface of login.
	 */
	public LoginUI() {
		this.setTitle("Login");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}

	/**
	 * To initial all components of user interface(UI).
	 */
	public void initComponents() {
		this.setLayout(new GridLayout(4, 2));
		titleLabel = new JLabel("HealthMe", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		titleLabel.setForeground(Color.WHITE);
		
		loginLabel = new JLabel("Username: ");
		
		nameTextfield = new JTextField(15);
		passwordLabel = new JLabel("Password: ");
		passwordTextfield = new JPasswordField(15);
		loginButton = new JButton("Login");
		registerButton = new JButton("Register");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connectDatabase();
			}
		});
		
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InformationUI informationUI = new InformationUI();
				informationUI.run();
				dispose();
			}
		});

		Panel panel0 = new Panel(new FlowLayout());
		panel0.setBackground(Color.BLACK);
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

	/**
	 * To check account and password of user. If input of user correct,
	 * application will show pick type page.
	 */
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
			boolean checkValidAcc = false;
			while (rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String activity = rs.getString("activity");
				int weight = rs.getInt("weight");
				int height = rs.getInt("height");
				int age = rs.getInt("age");
				if (passwordTextfield.getText().equals(password) && name.equals(nameTextfield.getText())) {
					user = new User(name, gender, age, weight, height, activity);
					user.caloriesNeeded();
					PickTypeUI ui = new PickTypeUI(user);
					ui.run();
					dispose();
					System.out.println("Login successfully");
					checkValidAcc = true;
					break;
				}
			}
			if (!checkValidAcc)
				JOptionPane.showMessageDialog(null, "Invalid username or password");
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	/**
	 * To show user interface of this frame.
	 */
	public void run() {
		this.setVisible(true);
	}
}
