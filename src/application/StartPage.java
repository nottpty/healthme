package application;

import javax.swing.JFrame;

public class StartPage extends JFrame implements Runnable {
	
	public StartPage() {
		this.setTitle("HealthMe");
		this.setSize(800, 450);
		initComponents();
	}
	
	public void initComponents() {
		
	}

	@Override
	public void run() {
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
