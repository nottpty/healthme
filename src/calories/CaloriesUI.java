package calories;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import application.PickTypeUI;
import user.User;

/**
 * A user interface that show calories by adding food in the list
 * 
 * @author Narut Poovorakit, Patinya Yongyai
 * 
 * @version 20.05.2017
 *
 */
public class CaloriesUI extends JFrame {

	private User user;
	private Food food;
	private JTextArea leftTextArea, rightTextArea;
	private JPanel panel;
	private JComboBox<String> foodBox, thaifoodBox;
	private JLabel caloriesNeedLabel, interFoodLabel, thaiFoodLabel;
	private JButton addBtn, addThaiBtn, backBtn;
	
	// All calories that been added.
	private double totalCalories;
	
	/**
	 * Create calories user interface.
	 * @param user is a given user with information.
	 */
	public CaloriesUI(User user) {
		this.user = user;
		totalCalories = user.getCalories();
		this.setTitle("HealthME");
		this.setSize(800, 450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
	
	/**
	 * Create and update component
	 */
	private void initComponents() {
		caloriesNeedLabel = new JLabel("");
		interFoodLabel = new JLabel("International Food", SwingConstants.CENTER);
		thaiFoodLabel = new JLabel("Thai food", SwingConstants.CENTER);
		addBtn = new JButton("ADD");
		addThaiBtn = new JButton("ADD");
		backBtn = new JButton("BACK");
		
		// Set text area
		leftTextArea = new JTextArea();
		rightTextArea = new JTextArea();
		leftTextArea.setSize(600, 200);
		rightTextArea.setSize(200, 200);
		leftTextArea.setText("Food name :\n");
		rightTextArea.setText("Calories :\n");
		leftTextArea.setFont(leftTextArea.getFont().deriveFont(25f));
		rightTextArea.setFont(leftTextArea.getFont().deriveFont(25f));
		
		caloriesNeedLabel.setText((int)user.getCaloriesNeeded() + " KCal remaining");
		caloriesNeedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		food = new Food();
		try {
			food.putFood();
			food.putThaiFood();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Set<String> keys = food.getFood().keySet();
		Set<String> keyThai = food.getThaiFood().keySet();
		
		String[] foodArr = keys.toArray(new String[keys.size()]);
		String[] thaifoodArr = keyThai.toArray(new String[keyThai.size()]);
		thaifoodBox = new JComboBox<String>(thaifoodArr);
		foodBox = new JComboBox<String>(foodArr);
		
		// Set font size
		caloriesNeedLabel.setFont(caloriesNeedLabel.getFont().deriveFont(30f));
		
		// Add listener
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String foodSelected = foodBox.getSelectedItem() + "";
				double calories = food.getFood().get(foodSelected);
				
				// Update total calories that eaten.
				totalCalories += calories;
				double updateCal = user.getCaloriesNeeded() - calories;
				user.setCaloriesNeeded(updateCal);
				caloriesNeedLabel.setText((int)updateCal + " KCal remaining");
				leftTextArea.append(foodBox.getSelectedItem()+"\n");
				rightTextArea.append(calories + " KCal\n");
			}
		});
		
		addThaiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String foodSelected = thaifoodBox.getSelectedItem() + "";
				double calories = food.getThaiFood().get(foodSelected);
				
				// Update total calories that eaten.
				totalCalories += calories;
				double updateCal = user.getCaloriesNeeded() - calories;
				user.setCaloriesNeeded(updateCal);
				caloriesNeedLabel.setText((int)updateCal + " KCal remaining");
				leftTextArea.append(thaifoodBox.getSelectedItem()+"\n");
				rightTextArea.append(calories + " KCal\n");
			}
		});
		
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				user.setCalories(totalCalories);
				PickTypeUI ui = new PickTypeUI(user);
				ui.run();
				dispose();
			}
		});
		
		panel = new JPanel();
		JPanel foodListPanel = new JPanel();
		JPanel thaifoodListPanel = new JPanel();
		JPanel textAreaPanel = new JPanel();
		JScrollPane leftscroll;
		JScrollPane rightscroll;
		
		foodListPanel.setLayout(new FlowLayout());
		thaifoodListPanel.setLayout(new FlowLayout());
		textAreaPanel.setLayout(new BoxLayout(textAreaPanel, BoxLayout.X_AXIS));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		foodListPanel.add(interFoodLabel);
		foodListPanel.add(foodBox);
		foodListPanel.add(addBtn);
		panel.add(foodListPanel);
		
		thaifoodListPanel.add(thaiFoodLabel);
		thaifoodListPanel.add(thaifoodBox);
		thaifoodListPanel.add(addThaiBtn);
		panel.add(thaifoodListPanel);
		
		
		leftscroll = new JScrollPane(leftTextArea,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		rightscroll = new JScrollPane(rightTextArea,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		leftscroll.setPreferredSize(new Dimension(600, 200));
		rightscroll.setPreferredSize(new Dimension(200, 200));
		
		textAreaPanel.add(leftscroll);
		textAreaPanel.add(rightscroll);
		panel.add(textAreaPanel);
		panel.add(backBtn);
		panel.add(caloriesNeedLabel);
		this.add(panel);
	}

	public void run() {
		this.setVisible(true);
	}

	
}
