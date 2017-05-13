package application;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javafx.scene.text.Font;
import user.User;

public class CaloriesUI extends JFrame implements Runnable {

	private User user;
	
	private JFrame frame;
	private JLabel caloriesNeedLabel;
	public CaloriesUI(User user) {
		this.user = user;
		frame = this;
		frame.setTitle("HealthME");
		frame.setSize(800, 450);
		initComponents();
	}
	
	private void initComponents() {
		caloriesNeedLabel = new JLabel("", SwingConstants.CENTER);
		caloriesNeedLabel.setText(user.caloriesNeeded() + " ");
		
		// Set font size
		caloriesNeedLabel.setFont(caloriesNeedLabel.getFont().deriveFont(70f));
		frame.add(caloriesNeedLabel);
	}

	@Override
	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
