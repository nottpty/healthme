package application;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import user.User;

import java.sql.*;

public class LoginUI extends JFrame {
	private JLabel loginLabel, passwordLabel;
	private JTextField nameTextfield, passwordTextfield;
	private JButton loginButton;
	private User user;

	public LoginUI() {
		this.setTitle("Login");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}

	public void initComponents() {
		this.setLayout(new FlowLayout());
		loginLabel = new JLabel("Input your name: ");
		nameTextfield = new JTextField(15);
		passwordLabel = new JLabel("Password: ");
		passwordTextfield = new JTextField(15);
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller();
			}
		});
		Panel panel1 = new Panel(new FlowLayout());
		Panel panel2 = new Panel(new FlowLayout());
		Panel panel3 = new Panel(new FlowLayout());
		panel1.add(loginLabel);
		panel1.add(nameTextfield);
		panel2.add(passwordLabel);
		panel2.add(passwordTextfield);
		panel3.add(loginButton);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.pack();
	}

	public void controller() {
		Connection c = null;
		Statement stmt = null;
		boolean validAccount = false;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:user.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER;");
			System.out.println(rs);
			while (rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String activity = rs.getString("activity");
				int age = rs.getInt("age");
				System.out.println("NAME = " + name);
				System.out.println("PASSWORD = " + password);
				if (passwordTextfield.getText().equals(password) && name.equals(nameTextfield.getText())) {
					user = new User(name, gender, age, weight, height, activity);
					user.caloriesNeeded();
					PickTypeUI ui = new PickTypeUI(user);
					ui.run();
					dispose();
					validAccount = true;
					System.out.println("Login successfully");
					break;
				}
			}
			rs.close();
			stmt.close();
			c.close();
			if(!validAccount) {
				InformationUI informationUI = new InformationUI();
				informationUI.run();
				System.out.println("Please register your account");
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	public void run() {
		this.setVisible(true);
	}
}
