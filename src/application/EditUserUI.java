package application;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import user.User;
import java.awt.Font;

public class EditUserUI extends JFrame implements Runnable {

	private JFrame frame;
	private User user;
	private JLabel nameLabel, ageLabel, weightLabel, heightLabel, genderLabel;
	private JTextField nameTxt, ageTxt, weightTxt, heightTxt;
	private JComboBox<String> genderBox;
	private JButton saveBtn;
	
	public EditUserUI(User user) {
		frame = this;
		this.user = user;
		initComponents();
	}
	
	private void initComponents() {
		nameLabel = new JLabel();
		weightLabel = new JLabel();
		genderLabel = new JLabel();
		nameTxt = new JTextField(10);
		weightTxt = new JTextField(10);
		ageTxt = new JTextField(10);
		ageLabel = new JLabel();
		heightLabel = new JLabel();
		heightTxt = new JTextField(10);
		saveBtn = new JButton("Save");
		
		heightLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		heightTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		weightLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		weightTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ageTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		saveBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		heightLabel.setText("Height: ");
		nameLabel.setText("Name: ");
		weightLabel.setText("Weight: ");
		genderLabel.setText("Gender: ");
		ageLabel.setText("Age: ");
		String[] genderArr = {"Male", "Female"};
		genderBox = new JComboBox(genderArr);
		genderBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				user.setName(nameTxt.getText());
				user.setAge(Integer.parseInt(ageTxt.getText()));
				user.setWeight(Double.parseDouble(weightTxt.getText()));
				user.setHeight(Double.parseDouble(heightTxt.getText()));
				user.setGender(genderBox.getSelectedItem() + "");
				System.out.println("Updated! " +
				nameTxt.getText() + " " + ageTxt.getText() + " " +
				weightTxt.getText() + " " + heightTxt.getText() + " " +
				genderBox.getSelectedItem());
				
				PickTypeUI pickTypeUI = new PickTypeUI(user);
				pickTypeUI.run();
				frame.dispose();
			}
		});
		
		JPanel namePanel = new JPanel();
		JPanel weightPanel = new JPanel();
		JPanel genderPanel = new JPanel();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		namePanel.add(nameLabel);
		namePanel.add(nameTxt);
		weightPanel.add(weightLabel);
		weightPanel.add(weightTxt);
		genderPanel.add(genderLabel);
		genderPanel.add(genderBox);
		
		
		JPanel agePanel = new JPanel();
		namePanel.add(agePanel);
		agePanel.add(ageLabel);
		agePanel.add(ageTxt);
		
		JPanel heightPanel = new JPanel();
		weightPanel.add(heightPanel);
		heightPanel.add(heightLabel);
		heightPanel.add(heightTxt);
		panel.add(namePanel);
		panel.add(weightPanel);
		panel.add(genderPanel);
		panel.add(saveBtn);
		frame.getContentPane().add(panel);
		
		
		
	}
	
	@Override
	public void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 450);
	}

}
