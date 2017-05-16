package absi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
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

/**
 * This is user interface for ABSI calculator. GUI of ABSI calculator can show
 * about mortality risk level of user by using personal information of user.
 * 
 * @author Patinya Yongyai
 *
 */
public class AbsiUI extends JFrame implements Observer {
	private JTextField ageTextField;
	private JTextField heightTextField;
	private JTextField weightTextField;
	private JTextField waistCircumTextField;
	private JButton calculateButton;
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
	public AbsiUI(Absi absi) {
		this.absi = absi;
		this.setTitle("ABSI Calculator");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
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
		resultLabel = new JLabel("", (int) CENTER_ALIGNMENT);
		resultLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Panel panel1 = new Panel(new FlowLayout());
		Panel panel2 = new Panel(new FlowLayout((int) LEFT_ALIGNMENT));
		Panel panel3 = new Panel(new FlowLayout((int) LEFT_ALIGNMENT));
		Panel panel4 = new Panel(new FlowLayout((int) LEFT_ALIGNMENT));
		Panel panel5 = new Panel(new FlowLayout((int) LEFT_ALIGNMENT));
		resultPanel = new Panel(new BorderLayout());
		Panel panel7 = new Panel(new BorderLayout());
		resultPanel.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(7, 1));
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
		panel7.add(calculateButton, BorderLayout.CENTER);
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
