package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import user.User;

public class PickTypeUI extends JFrame implements Runnable{

	private User user;
	private JFrame frame;
	private JButton caloriesBtn;
	
	public PickTypeUI(User user) {
		this.user = user;
		frame = this;
		frame.setSize(800,  450);
		initComponents();
	}
	
	private void initComponents() {
		caloriesBtn = new JButton("CALORIES");
		
		caloriesBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				CaloriesUI caloriesUI = new CaloriesUI(user);
				caloriesUI.run();
				frame.dispose();
			}
		});
		
		frame.add(caloriesBtn);
	}
	
	@Override
	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
