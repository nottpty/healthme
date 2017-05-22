package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import absi.Absi;
import absi.AbsiUI;
import calories.CaloriesUI;
import javafx.scene.shape.Box;
import user.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * A page that show information of user, user can update their information and can pick
 * an absi page or calories page.
 * 
 * @author Narut Poovorakit
 *
 * @version 20.05.2017
 */
public class PickTypeUI extends JFrame implements Runnable{

	private User user;
	private JFrame frame;
	private JProgressBar caloriesBar;
	private JLabel nameLabel, ageLabel, genderLabel, todayCaloriesLabel, weightLabel, heightLabel;
	private JButton caloriesBtn, absiBtn, editUserBtn;
	
	/**
	 * Create UI
	 * @param user is a given user with name, age and gender
	 */
	public PickTypeUI(User user) {
		this.user = user;
		frame = this;
		frame.setSize(800,  450);
		initComponents();
	}
	
	private void initComponents() {
		JPanel labelPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel progressPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		caloriesBtn = new JButton("CALORIES");
		caloriesBtn.setFont(new Font("Tahoma", Font.PLAIN, 50));
		absiBtn = new JButton("ABSI");
		absiBtn.setFont(new Font("Tahoma", Font.PLAIN, 50));
		editUserBtn = new JButton("EDIT USER");
		
		nameLabel = new JLabel();
		ageLabel = new JLabel();
		genderLabel = new JLabel();
		todayCaloriesLabel = new JLabel();
		weightLabel = new JLabel();
		heightLabel = new JLabel();
		
		caloriesBar = new JProgressBar(0, 2000);
		caloriesBar.setMaximumSize(new Dimension(0, user.getfinalCalories()));
		caloriesBar.setValue(user.getCalories());
		caloriesBar.setStringPainted(true);
		
		caloriesBar.setPreferredSize(new Dimension(700, 50));
		nameLabel.setPreferredSize(new Dimension(150, 100));
		ageLabel.setPreferredSize(new Dimension(100, 100));
		genderLabel.setPreferredSize(new Dimension(100, 100));
		todayCaloriesLabel.setPreferredSize(new Dimension(150, 100));
		weightLabel.setPreferredSize(new Dimension(100, 100));
		heightLabel.setPreferredSize(new Dimension(100, 100));
		caloriesBtn.setPreferredSize(new Dimension(350, 200));
		absiBtn.setPreferredSize(new Dimension(350, 200));
		
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));	
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		todayCaloriesLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		weightLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		heightLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		absiBtn.setBackground(new Color(59, 89, 182));
		absiBtn.setForeground(Color.WHITE);
		caloriesBtn.setBackground(new Color(59, 89, 182));
		caloriesBtn.setForeground(Color.WHITE);
		
		nameLabel.setText("Username: " + user.getName());
		ageLabel.setText("Age: " + user.getAge() + "");
		genderLabel.setText("Gender: " + user.getGender());
		todayCaloriesLabel.setText("Calories: " + user.getCalories() + "/" + user.getfinalCalories());
		weightLabel.setText("Weight: " + user.getWeight());
		heightLabel.setText("Height: " + user.getHeight());
		
		// Add listener
		caloriesBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				CaloriesUI caloriesUI = new CaloriesUI(user);
				caloriesUI.run();
				frame.dispose();
			}
		});
		
		absiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Absi absi = new Absi();
				AbsiUI absiUI = new AbsiUI(absi, user);
				absi.addObserver(absiUI);
				absiUI.run();
				frame.dispose();
			}
		});
		
		editUserBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditUserUI editUI = new EditUserUI(user);
				editUI.run();
				frame.dispose();
			}
		});
		
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		labelPanel.add(nameLabel);
		labelPanel.add(ageLabel);
		labelPanel.add(genderLabel);
		labelPanel.add(weightLabel);
		labelPanel.add(heightLabel);
		labelPanel.add(todayCaloriesLabel);
		progressPanel.add(caloriesBar);
		northPanel.add(labelPanel);
		northPanel.add(progressPanel);
		centerPanel.add(absiBtn);
		centerPanel.add(caloriesBtn);
		southPanel.add(editUserBtn);
		
		frame.setLayout(new BorderLayout());
		frame.add(northPanel, BorderLayout.NORTH);
		
		frame.add(centerPanel, BorderLayout.CENTER);
		frame.add(southPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
