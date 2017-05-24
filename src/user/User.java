package user;

import calories.CalculateCalories;

/**
 * A user that contain name, gender, activity, weight, height, waistcircum
 * calories that eaten, final calories that must eat, an update calories that a result of
 * calories needed - calories eaten and age.
 * 
 * @author Narut Poovorakit
 *  
 * @version 24.05.2017
 *
 */
public class User {

	// activity is a daily life activity
	private String name, gender, activity;
	
	//waistcircum
	private double weight, height, waistcircum;
	
	// unit is Kcal
	// references : https://authoritynutrition.com/how-many-calories-per-day/
	private int calories, finalCalories, caloriesNeeded, age;
	
	/**
	 * User with given name, gender, activity and age
	 * @param name is a name of user 
	 * @param gender is a gender (male, female)
	 * @param activity is an activity that user do per day divided in 3 choice
	 * Sedentary activity - Doesn't do much in that day (Ex. At home doesn't do anything that use energy) 
	 * Moderate activity - Doing some of the activities that use energy. 
	 * Active activity - Doing many activities that use a lot of energy (Ex. Play sports, doing exam)
	 * @param age is an age of the user
	 */
	public User(String name, String gender, String activity, int age) {
		this.name = name;
		this.gender = gender;
		this.activity = activity;
		this.age = age;
		calories = 0;
		finalCalories = 0;
		caloriesNeeded = 0;
	}
	
	/**
	 * Get a calories needed calculate by using an information of user.
	 * @return a calories needed
	 */
	public int caloriesNeeded() {
		CalculateCalories cal = new CalculateCalories();
		caloriesNeeded = cal.calculateCal(gender, age, activity);
		finalCalories = caloriesNeeded;
		return caloriesNeeded;
	}
	
	/**
	 * return name of user.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * return calories of user that eaten.
	 */
	public int getCalories() {
		return this.calories;
	}
	
	/**
	 * return gender of a user.
	 */
	public String getGender() {
		return this.gender;
	}
	
	/**
	 * return weight of user.
	 */
	public double getWeight() {
		return this.weight;
	}
	
	/**
	 * return height of user.
	 */
	public double getHeight() {
		return this.height;
	}
	
	/**
	 * return age of user.
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * return waist of user.
	 */
	public double getWaist() {
		return this.waistcircum;
	}
	
	/**
	 * return activity of user.
	 */
	public String getActivity() {
		return this.activity;
	}
	
	/**
	 * return update calories needed per day.
	 */
	public int getCaloriesNeeded() {
		return this.caloriesNeeded;
	}

	/**
	 * return final calories that needed per day.
	 */
	public int getfinalCalories() {
		return this.finalCalories;
	}
	
	/**
	 * Update final calories.
	 */
	public void setfinalCalories(int finalCalories) {
		this.finalCalories = finalCalories;
	}
	
	/**
	 * Set a new name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set a new gender.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * Set a new weight.
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	 * Set a new height.
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * Set a new age.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Set a new waist.
	 */
	public void setWaist(double waist) {
		this.waistcircum = waist;
	}
	
	/**
	 * Set a new activity.
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	/**
	 * Update calories that needed per day.
	 */
	public void setCaloriesNeeded(int caloriesNeed) {
		this.caloriesNeeded = caloriesNeed;
	}
	
	/**
	 * Set a calories that eaten that day.
	 */
	public void setCalories(int calories) {
		this.calories = calories;
	}
}
