package absi;

import java.util.Arrays;

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
	private double zScore;

	public void setInfo(String gender, int age, double height, double weight, double waist_circum) {
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.waist_circum = waist_circum;
	}

	public double getValue() {
		double bmi = weight / Math.pow((height / 100), 2);
		double absiValue = (waist_circum/100) / (Math.cbrt(Math.pow(bmi, 2)) * Math.sqrt(height/100));
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
	
	public void findZscore() {
		CSVReader csvReader = new CSVReader("src/absi/zScore.txt");
		String[] strArr = null;
		double absiMean = 0;
		double absiSd = 0;
		while (csvReader.hasNext()) {
			strArr = csvReader.next();
			if (strArr[0].equals(age+"")){
				break;
			}
		}
		if(gender.equals("Male")) {
			absiMean = Double.parseDouble(strArr[1]);
			absiSd = Double.parseDouble(strArr[2]);
		} else {
			absiMean = Double.parseDouble(strArr[3]);
			absiSd = Double.parseDouble(strArr[4]);
		}
		zScore = (getValue()-absiMean)/absiSd;
	}

	public double getZscore() {
		return zScore;
	}
}
