package application;
import java.awt.Component;
import java.awt.Dimension;
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
	private JButton saveBtn;
	
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
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ageTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		saveBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		heightLabel.setText("Height: ");
		nameLabel.setText("Name: ");
		weightLabel.setText("Weight: ");
		activityLabel.setText("Activity: ");
		ageLabel.setText("Age: ");
		String[] activityArr = {"Sedentary", "Lightly Active", "Moderately Active", "Very Active", "Extremely Active"};
		activityBox = new JComboBox<String>(activityArr);
		activityBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				user.setAge(Integer.parseInt(ageTxt.getText()));
				user.setWeight(Integer.parseInt(weightTxt.getText()));
				user.setHeight(Integer.parseInt(heightTxt.getText()));
				user.setActivity(activityBox.getSelectedItem() + "");
				updateDatabase();
				
				PickTypeUI pickTypeUI = new PickTypeUI(user);
				pickTypeUI.run();
				dispose();
			}
		});
		
		JPanel namePanel = new JPanel();
		JPanel weightPanel = new JPanel();
		JPanel genderPanel = new JPanel();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		namePanel.add(nameLabel);
		namePanel.add(nameTxt);
		weightPanel.add(weightLabel);
		weightPanel.add(weightTxt);
		genderPanel.add(activityLabel);
		genderPanel.add(activityBox);
		
		
		JPanel agePanel = new JPanel();
		namePanel.add(agePanel);
		agePanel.add(ageLabel);
		agePanel.add(ageTxt);
		
		JPanel heightPanel = new JPanel();
		weightPanel.add(heightPanel);
		heightPanel.add(heightLabel);
		heightPanel.add(heightTxt);
		panel.add(namePanel);
		panel.add(weightPanel);
		panel.add(genderPanel);
		panel.add(saveBtn);
		this.getContentPane().add(panel);
		
		
		
	}
	
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
	    	  String sql = "UPDATE USER set WEIGHT = "+weightTxt.getText()+" where NAME="+user.getName()+";";
	    	  System.out.println(sql);
		      stmt.executeUpdate(sql);
	      }
	      if(!heightTxt.getText().equals("")) {
	    	  String sql = "UPDATE USER set HEIGHT = "+heightTxt.getText()+" where NAME="+user.getName()+";";
		      stmt.executeUpdate(sql);
	      }
	      if(!ageTxt.getText().equals("")) {
	    	  String sql = "UPDATE USER set AGE = "+ageTxt.getText()+" where NAME="+user.getName()+";";
		      stmt.executeUpdate(sql);
	      }
	      if(!activityBox.getSelectedItem().equals("")) {
	    	  String sql = "UPDATE USER set ACTIVITY = "+activityBox.getSelectedItem() +" where NAME="+user.getName()+";";
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
	
	public void run() {
		this.setVisible(true);
	}

}
