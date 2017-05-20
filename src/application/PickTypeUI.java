package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import absi.Absi;
import absi.AbsiUI;
import calories.CaloriesUI;
import user.User;
import java.awt.Font;

public class PickTypeUI extends JFrame implements Runnable{

	private User user;
	private JFrame frame;
	private JButton caloriesBtn, absiBtn, editUserBtn;
	
	public PickTypeUI(User user) {
		this.user = user;
		frame = this;
		frame.setSize(800,  450);
		initComponents();
	}
	
	private void initComponents() {
		caloriesBtn = new JButton("CALORIES");
		caloriesBtn.setFont(new Font("Tahoma", Font.PLAIN, 70));
		caloriesBtn.setBounds(401, 0, 400, 411);
		absiBtn = new JButton("ABSI");
		absiBtn.setFont(new Font("Tahoma", Font.PLAIN, 70));
		absiBtn.setBounds(0, 0, 400, 411);
		editUserBtn = new JButton("EDIT USER");
		
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
				
			}
		});
		getContentPane().setLayout(null);
		
		frame.getContentPane().add(absiBtn);
		frame.getContentPane().add(caloriesBtn);
	}
	
	@Override
	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
