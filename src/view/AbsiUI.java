package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import absi.Absi;
import user.User;

/**
 * This is user interface for ABSI calculator. GUI of ABSI calculator can show
 * about mortality risk level of user by using personal information of user.
 * 
 * @author Patinya Yongyai
 *
 */
public class AbsiUI extends JFrame implements Observer {

	private User user;
	private JTextField ageTextField;
	private JTextField heightTextField;
	private JTextField weightTextField;
	private JTextField waistCircumTextField;
	private JButton calculateButton;
	private JButton backBtn;
	private JLabel genderLabel;
	private JLabel ageLabel;
	private JLabel heightLabel;
	private JLabel weightLabel;
	private JLabel waistCircumLabel;
	private Absi absi;
	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private JLabel resultLabel;
	private Panel resultPanel;

	/**
	 * Constructor to initialize this class and set default setting of GUI.
	 * 
	 * @param absi
	 *            is a reference from a main method to initialize Absi class in
	 *            this class.
	 */
	public AbsiUI(Absi absi, User user) {
		this.user = user;
		this.absi = absi;
		this.setTitle("ABSI Calculator");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

	/**
	 * To initialize all components.
	 */
	public void initComponents() {
		maleRadioButton = new JRadioButton("Male");
		maleRadioButton.setSelected(true);
		femaleRadioButton = new JRadioButton("Female");
		genderLabel = new JLabel("Gender: ");
		ageLabel = new JLabel("Age: ");
		heightLabel = new JLabel("Height (cm): ");
		weightLabel = new JLabel("Weight (kg): ");
		waistCircumLabel = new JLabel("Waist circumference (cm): ");
		ageTextField = new JTextField(3);
		heightTextField = new JTextField(3);
		weightTextField = new JTextField(3);
		waistCircumTextField = new JTextField(3);
		calculateButton = new JButton("Calculate Now!");
		backBtn = new JButton("Back");
		resultLabel = new JLabel("", (int) CENTER_ALIGNMENT);
		resultLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		Panel panel1 = new Panel(new FlowLayout());
		panel1.setBackground(Color.WHITE);
		Panel panel2 = new Panel(new FlowLayout((int) LEFT_ALIGNMENT));
		panel2.setBackground(Color.WHITE);
		Panel panel3 = new Panel(new FlowLayout((int) LEFT_ALIGNMENT));
		panel3.setBackground(Color.WHITE);
		Panel panel4 = new Panel(new FlowLayout((int) LEFT_ALIGNMENT));
		panel4.setBackground(Color.WHITE);
		Panel panel5 = new Panel(new FlowLayout((int) LEFT_ALIGNMENT));
		panel5.setBackground(Color.WHITE);
		resultPanel = new Panel(new BorderLayout());
		resultPanel.setBackground(Color.WHITE);
		Panel panel7 = new Panel(new FlowLayout());
		panel7.setBackground(Color.WHITE);
		resultPanel.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(7, 1));
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PickTypeUI pickTypeUI = new PickTypeUI(user);
				pickTypeUI.run();
				dispose();
			}
		});
		maleRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				femaleRadioButton.setSelected(false);
			}
		});
		femaleRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				maleRadioButton.setSelected(false);
			}
		});
		calculateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (maleRadioButton.isSelected()) {
					absi.setInfo(maleRadioButton.getText(), Integer.parseInt(ageTextField.getText()),
							Double.parseDouble(heightTextField.getText()),
							Double.parseDouble(weightTextField.getText()),
							Double.parseDouble(waistCircumTextField.getText()));
				} else {
					absi.setInfo(femaleRadioButton.getText(), Integer.parseInt(ageTextField.getText()),
							Double.parseDouble(heightTextField.getText()),
							Double.parseDouble(weightTextField.getText()),
							Double.parseDouble(waistCircumTextField.getText()));
				}
			}
		});
		panel1.add(genderLabel);
		panel1.add(maleRadioButton);
		panel1.add(femaleRadioButton);
		panel2.add(ageLabel);
		panel2.add(ageTextField);
		panel3.add(heightLabel);
		panel3.add(heightTextField);
		panel4.add(weightLabel);
		panel4.add(weightTextField);
		panel5.add(waistCircumLabel);
		panel5.add(waistCircumTextField);
		resultPanel.add(resultLabel);
		panel7.add(backBtn);
		panel7.add(calculateButton);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		this.add(resultPanel);
		this.add(panel7);
		this.pack();
	}

	/**
	 * To show GUI of this object.
	 */
	public void run() {
		this.setVisible(true);
	}

	/**
	 * Update UI when information of user was updated.
	 */
	@Override
	public void update(Observable o, Object arg) {
		resultLabel.setText(absi.getMortalityRisk());
		if (absi.getMortalityRisk().equals("Very Low") || absi.getMortalityRisk().equals("Low"))
			resultPanel.setBackground(Color.GREEN);
		else if (absi.getMortalityRisk().equals("Average"))
			resultPanel.setBackground(Color.YELLOW);
		else if (absi.getMortalityRisk().equals("High") || absi.getMortalityRisk().equals("Very High"))
			resultPanel.setBackground(Color.RED);
	}

}
