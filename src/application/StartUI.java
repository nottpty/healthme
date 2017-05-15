package application;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class StartUI extends JFrame implements Runnable {
	
	private JButton button;
	private JLabel title;
	private JFrame frame;
	
	public StartUI() {
		setResizable(false);
		frame = this;
		frame.setTitle("HealthMe");
		frame.setSize(800, 450);
		initComponents();
	}
	
	private void initComponents() {
		button = new JButton("START");
		title = new JLabel("HealthMe", SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 86));
		title.setBounds(0, 0, 784, 242);
		button.setBounds(300, 303, 200, 44);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InformationUI informationUI = new InformationUI();
				informationUI.run();
			}
		});
		getContentPane().setLayout(null);
		
		getContentPane().add(title);
		getContentPane().add(button);
	}

	@Override
	public void run() {
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
