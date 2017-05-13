package application;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StartUI extends JFrame implements Runnable {
	
	private JButton button;
	private JLabel title;
	private JFrame frame;
	
	public StartUI() {
		frame = this;
		frame.setTitle("HealthMe");
		frame.setSize(800, 450);
		initComponents();
	}
	
	public void initComponents() {
		button = new JButton("START");
		title = new JLabel("HealthMe", SwingConstants.CENTER);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InformationUI informationUI = new InformationUI();
				informationUI.run();
			}
		});
		
		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(button, BorderLayout.SOUTH);
	}

	@Override
	public void run() {
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
