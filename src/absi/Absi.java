package absi;

/**
 * A Body Shape Index (ABSI) calculator takes your weight, height and waist
 * circumference and calculates the ABSI value.
 * 
 * @author Patinya Yongyai
 *
 */
public class Absi {
	private double height, weight, waist_circum;
	private int age;
	private String gender;

	public void setInfo(String gender, int age, double height, double weight, double waist_circum) {
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.waist_circum = waist_circum;
	}

	public double getValue() {
		double bmi = weight / Math.pow((height / 100), 2);
		double absiValue = waist_circum / (Math.cbrt(Math.pow(bmi, 2)) * Math.sqrt(height));
		return absiValue;
	}

	public String getMortalityRisk() {
		if (getZscore() < -0.868)
			return "Very Low";
		else if (getZscore() >= -0.868 && getZscore() <= -0.272)
			return "Low";
		else if (getZscore() >= -0.272 && getZscore() <= 0.229)
			return "Average";
		else if (getZscore() >= 0.229 && getZscore() <= 0.789)
			return "High";
		return "Very High";
	}

	public double getZscore() {
		// read the data from a text file in local storage
		// male and female are not same result.
		return 0.0;
	}
}
