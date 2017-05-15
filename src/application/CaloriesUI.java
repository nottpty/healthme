package application;

import java.awt.FlowLayout;
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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import javafx.scene.text.Font;
import user.Food;
import user.User;

public class CaloriesUI extends JFrame implements Runnable {

	private User user;
	private Food food;
	
	private JFrame frame;
	private JTextArea textArea;
	private JPanel panel;
	private JComboBox<String> foodBox;
	private JLabel caloriesNeedLabel;
	private JButton addBtn, backBtn;
	
	public CaloriesUI(User user) {
		this.user = user;
		frame = this;
		frame.setTitle("HealthME");
		frame.setSize(800, 450);
		initComponents();
	}
	
	private void initComponents() {
		caloriesNeedLabel = new JLabel("", SwingConstants.CENTER);
		addBtn = new JButton("ADD");
		backBtn = new JButton("BACK");
		textArea = new JTextArea();
		
		caloriesNeedLabel.setText(user.caloriesNeeded() + " KCal remaining");
		
		food = new Food();
		try {
			food.putFood();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Set<String> keys = food.getFood().keySet();
		
		String[] foodArr = keys.toArray(new String[keys.size()]);
		foodBox = new JComboBox<String>(foodArr);
		
		
		// Set font size
		caloriesNeedLabel.setFont(caloriesNeedLabel.getFont().deriveFont(30f));
		
		// Add listener
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String foodSelected = foodBox.getSelectedItem() + "";
				int calories = food.getFood().get(foodSelected);
				int updateCal = user.getCaloriesNeeded() - calories;
				user.setCaloriesNeeded(updateCal);
				caloriesNeedLabel.setText(updateCal + " KCal remaining");
			}
		});
		
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PickTypeUI ui = new PickTypeUI(user);
				ui.run();
				frame.dispose();
			}
		});
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(foodBox);
		panel.add(addBtn);
		panel.add(backBtn);
		panel.add(textArea);
		panel.add(caloriesNeedLabel);
		frame.add(panel);
	}

	@Override
	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
