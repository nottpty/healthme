package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import user.User;
import java.awt.Font;
import java.awt.Toolkit;

import java.sql.*;

/**
 * A page that can update a basic information of user.
 * 
 * @author Narut Poovorakit, Patinya Yongyai
 *
 * @version 20.05.2017
 */
public class EditUserUI extends JFrame {

	private User user;
	private JLabel nameLabel, ageLabel, weightLabel, heightLabel, activityLabel;
	private JTextField nameTxt, ageTxt, weightTxt, heightTxt;
	private JComboBox<String> activityBox;
	private JButton saveBtn, backBtn;
	
	/**
	 * Create UI with given user
	 */
	public EditUserUI(User user) {
		this.user = user;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 450);
		initComponents();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
	
	/**
	 * To initial all components of user interface(UI).
	 */
	private void initComponents() {
		nameLabel = new JLabel();
		weightLabel = new JLabel();
		activityLabel = new JLabel();
		nameTxt = new JTextField(10);
		weightTxt = new JTextField(10);
		ageTxt = new JTextField(10);
		ageLabel = new JLabel();
		heightLabel = new JLabel();
		heightTxt = new JTextField(10);
		saveBtn = new JButton("Save");
		backBtn = new JButton("Back");
		
		heightLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		heightTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		weightLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		activityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTxt.setText(user.getName());
		nameTxt.setEditable(false);
		weightTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ageTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		saveBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		heightLabel.setText("Height: ");
		nameLabel.setText("Username: ");
		weightLabel.setText("Weight: ");
		activityLabel.setText("Activity: ");
		ageLabel.setText("Age: ");
		String[] activityArr = {"Sedentary", "Lightly Active", "Moderately Active", "Very Active", "Extremely Active"};
		activityBox = new JComboBox<String>(activityArr);
		activityBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!ageTxt.getText().isEmpty()) 
					user.setAge(Integer.parseInt(ageTxt.getText()));
				if (!weightTxt.getText().isEmpty()) 
					user.setWeight(Integer.parseInt(weightTxt.getText()));
				if (!heightTxt.getText().isEmpty())
					user.setHeight(Integer.parseInt(heightTxt.getText()));
				if (activityBox.getSelectedItem() != null)
					user.setActivity(activityBox.getSelectedItem() + "");
				user.caloriesNeeded();
				updateDatabase();
				JOptionPane.showMessageDialog(null, "Edit succesful");
				PickTypeUI pickTypeUI = new PickTypeUI(user);
				pickTypeUI.run();
				dispose();
			}
		});
		
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PickTypeUI pickTypeUI = new PickTypeUI(user);
				pickTypeUI.run();
				dispose();
			}
		});
		
		JPanel namePanel = new JPanel();
		namePanel.setBackground(Color.WHITE);
		JPanel weightPanel = new JPanel();
		weightPanel.setBackground(Color.WHITE);
		JPanel genderPanel = new JPanel();
		genderPanel.setBackground(Color.WHITE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		namePanel.add(nameLabel);
		namePanel.add(nameTxt);
		weightPanel.add(weightLabel);
		weightPanel.add(weightTxt);
		genderPanel.add(activityLabel);
		genderPanel.add(activityBox);
		
		
		JPanel agePanel = new JPanel();
		agePanel.setBackground(Color.WHITE);
		namePanel.add(agePanel);
		agePanel.add(ageLabel);
		agePanel.add(ageTxt);
		
		JPanel heightPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		heightPanel.setBackground(Color.WHITE);
		weightPanel.add(heightPanel);
		heightPanel.add(heightLabel);
		heightPanel.add(heightTxt);
		panel.add(namePanel);
		panel.add(weightPanel);
		panel.add(genderPanel);
		buttonPanel.add(backBtn);
		buttonPanel.add(saveBtn);
		panel.add(buttonPanel);
		this.getContentPane().add(panel);
	}
	
	/**
	 * Update data in database.
	 */
	public void updateDatabase() {
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:user.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      if(!weightTxt.getText().equals("")) {
	    	  String sql = "UPDATE USER set WEIGHT = "+weightTxt.getText()+" where NAME="+'\''+user.getName()+'\''+";";
		      stmt.executeUpdate(sql);
	      }
	      if(!heightTxt.getText().equals("")) {
	    	  String sql = "UPDATE USER set HEIGHT = "+heightTxt.getText()+" where NAME="+'\''+user.getName()+'\''+";";
		      stmt.executeUpdate(sql);
	      }
	      if(!ageTxt.getText().equals("")) {
	    	  String sql = "UPDATE USER set AGE = "+ageTxt.getText()+" where NAME="+'\''+user.getName()+'\''+";";
		      stmt.executeUpdate(sql);
	      }
	      if(!activityBox.getSelectedItem().equals("")) {
	    	  String sql = "UPDATE USER set ACTIVITY = "+'\''+activityBox.getSelectedItem()+'\''+" where NAME="+'\''+user.getName()+'\''+";";
		      stmt.executeUpdate(sql);
	      }
	      c.commit();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
	    System.out.println("Operation done successfully");
	}
	
	/**
	 * Show user interface of this frame.
	 */
	public void run() {
		this.setVisible(true);
	}

}
