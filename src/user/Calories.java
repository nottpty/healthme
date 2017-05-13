package user;

public class Calories {

	public int calculateCal(String gender, int age, String activity) {
		int calories = 0;
		if (age == 2) {
			calories = 1000;
		}

		else if (age == 3) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1200;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 1400;
				}

				if (activity.equalsIgnoreCase("Active")) {
					calories = 1600;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1200;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 1400;
				}

				if (activity.equalsIgnoreCase("Active")) {
					calories = 1400;
				}
			}
		}

		else if (age == 4) {
			if (activity.equalsIgnoreCase("Sedentary")) {
				calories = 1200;
			}

			if (activity.equalsIgnoreCase("Moderately Active")) {
				calories = 1400;
			}

			if (activity.equalsIgnoreCase("active")) {
				calories = 1600;
			}
		}

		else if (age == 5) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1400;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 1600;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 1800;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1200;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 1400;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 1600;
				}
			}
		}

		else if (age == 6) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1200;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 1400;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 1600;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1200;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 1400;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 1600;
				}
			}
		}

		else if (age == 7) {

		}

		else if (age == 8) {

		}

		else if (age == 9) {

		}

		else if (age == 10) {

		}

		else if (age == 11) {

		}

		else if (age == 12) {

		}

		else if (age == 13) {

		}

		else if (age == 14) {

		}

		else if (age == 15) {

		}

		else if (age == 16) {

		}

		else if (age == 17) {

		}

		else if (age == 18) {

		}

		else if (age >= 19 && age <= 20) {

		}

		else if (age >= 21 && age <= 25) {

		}

		else if (age >= 26 && age <= 30) {

		}

		else if (age >= 31 && age <= 35) {

		}

		else if (age >= 36 && age <= 40) {

		}

		else if (age >= 41 && age <= 45) {

		}

		else if (age >= 46 && age <= 50) {

		}

		else if (age >= 51 && age <= 55) {

		}

		else if (age >= 56 && age <= 60) {

		}

		else if (age >= 61) {

		}

		return calories;
	}
}
