package absi;

/**
 * 
 * @author Patinya Yongyai
 *
 */
public class Absi {
	private double height, weight, waist_circum;
	private int age;
	private String gender;
	// A risk categories that categorized by absi score.
	private String riskCategory;
	
	public Absi(String gender, int age, double height, double weight, double waist_circum) {
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.waist_circum = waist_circum;
	}
	
	public double getAbsiValue() {
		double bmi = weight/Math.pow((height/100), 2);
		double absiValue = waist_circum/(Math.cbrt(Math.pow(bmi, 2)) * Math.sqrt(height));
		return absiValue;
	}
}
