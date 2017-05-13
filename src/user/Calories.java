package user;

/**
 * Calories that needed per day.
 * Data from https://www.cnpp.usda.gov/sites/default/files/usda_food_patterns/EstimatedCalorieNeedsPerDayTable.pdf
 * @author molecuess
 *
 */
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
					calories = 1600;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 1800;
				}
			}
		}

		else if (age == 7) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1400;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 1600;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2000;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1400;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 1600;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 1800;
				}
			}
		}

		else if (age >= 8 && age <= 10) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1600;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 1800;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2000;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1400;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 1600;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 1800;
				}
			}
		}

		else if (age == 11) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1800;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 2000;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2200;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1600;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 1800;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2000;
				}
			}
		}

		else if (age == 12) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1800;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 2200;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2400;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1600;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 2000;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2200;
				}
			}
		}

		else if (age <= 13 && age >= 15) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 2100;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 2400;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2600;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1700;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 2000;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2200;
				}
			}
		}
		
		else if (age <= 16 && age >= 18) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 2400;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 2800;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 3200;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1800;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 2000;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2400;
				}
			}
		}

		else if (age >= 19 && age <= 20) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 2600;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 2800;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 3000;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 2000;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 2200;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2400;
				}
			}
		}

		else if (age >= 21 && age <= 25) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 2400;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 2800;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 3000;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 2000;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 2200;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2400;
				}
			}
		}

		else if (age >= 26 && age <= 30) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 2400;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 2600;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 3000;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1800;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 2000;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2400;
				}
			}
		}

		else if (age >= 31 && age <= 40) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 2400;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 2600;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 3000;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1800;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 2000;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2200;
				}
			}
		}
		
		else if (age >= 41 && age <= 50) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 2200;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 2600;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2800;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1800;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 2000;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2200;
				}
			}
		}

		else if (age >= 51 && age <= 60) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 2200;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 2400;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2800;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1600;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 1800;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2200;
				}
			}
		}

		else if (age >= 61) {
			if (gender.equalsIgnoreCase("Male")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 2000;
				}

				if (activity.equalsIgnoreCase("Moderately Active")) {
					calories = 2400;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2600;
				}
			}

			if (gender.equalsIgnoreCase("Female")) {
				if (activity.equalsIgnoreCase("Sedentary")) {
					calories = 1600;
				}

				if (activity.equalsIgnoreCase("moderately active")) {
					calories = 1800;
				}

				if (activity.equalsIgnoreCase("active")) {
					calories = 2200;
				}
			}
		}

		return calories;
	}
}
