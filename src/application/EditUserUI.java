package application;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import user.User;

public class EditUserUI extends JFrame implements Runnable {

	private User user;
	private JLabel nameLabel, ageLabel, weightLabel, heightLabel, genderLabel;
	private JTextField nameTxt, ageTxt, weightTxt, heightTxt, genderTxt;
	
	public EditUserUI(User user) {
		this.user = user;
		initComponents();
	}
	
	private void initComponents() {
		nameLabel = new JLabel();
		ageLabel = new JLabel();
	}
	
	@Override
	public void run() {
		
	}

}
