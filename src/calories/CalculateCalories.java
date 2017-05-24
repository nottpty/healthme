package calories;

/**
 * Calculate calories that needed per day. references :
 * http://www.superskinnyme.com/calculate-tdee.html
 * 
 * @author Narut Poovorakit
 *
 * @version 24.05.2017
 */
public class CalculateCalories {

	/**
	 * Calculate a needed calories of user each day.
	 * 
	 * @param gender
	 *            is a given gender (male, female)
	 * @param age
	 *            is a given age
	 * @param activity
	 *            is a given activity (sedentary, moderate, active)
	 * @return a result of calories needed per day.
	 */
	public double calculateCal(String gender, int age, int weight, int height, String activity) {
		// formula of calories needed = BMR * TDEE
		double calories = 0;

		System.out.println(weight);
		System.out.println(height);
		System.out.println(age);
		// BMR formula
		if (gender.equalsIgnoreCase("female")) {
			calories = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
			System.out.println("Calories:" + calories);
		} else {
			calories = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
			System.out.println(calories);
		}

		// TDEE
		// Sedentary is Little or no Exercise/desk job
		if (activity.equalsIgnoreCase("Sedentary")) {
			calories *= 1.2;
		}
		// Light exercise/sports 1 – 3 days/ week
		if (activity.equalsIgnoreCase("Lightly active")) {
			calories *= 1.375;
		}
		// Moderate Exercise, sports 3 – 5 days/ week
		if (activity.equalsIgnoreCase("Moderately active")) {
			calories *= 1.55;
		}
		// Heavy Exercise/ sports 6 – 7 days/ week
		if (activity.equalsIgnoreCase("Very active")) {
			calories *= 1.725;
		}
		// Very heavy exercise/ physical job
		if (activity.equalsIgnoreCase("extremely active")) {
			calories *= 1.9;
		}
		return calories;
	}
}
