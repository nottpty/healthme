package user;

import java.util.HashMap;
import java.util.Map;

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
	private double waistcircum, calories, finalCalories, caloriesNeeded;
	
	// unit is Kcal
	// references : https://authoritynutrition.com/how-many-calories-per-day/
	private int age, weight, height;
	
	private Map<String, Double> foodList;
	
	/**
	 * User with given name, gender, activity and age
	 * @param name is a name of user 
	 * @param gender is a gender (male, female)
	 * @param activity is how often that user do exercise or activity in daily life.
	 * @param age is an age of the user
	 */
	public User(String name, String gender, int age, int weight, int height, String activity) {
		this.name = name;
		this.gender = gender;
		this.activity = activity;
		this.age = age;
		this.weight = weight;
		this.height = height;
		foodList = new HashMap<String, Double>();
		calories = 0;
		finalCalories = 0;
		caloriesNeeded = 0;
	}
	
	/**
	 * Get a calories needed calculate by using an information of user.
	 * @return a calories needed
	 */
	public double caloriesNeeded() {
		CalculateCalories cal = new CalculateCalories();
		caloriesNeeded = cal.calculateCal(gender, age, weight, height, activity);
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
	public double getCalories() {
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
	public double getCaloriesNeeded() {
		return this.caloriesNeeded;
	}

	/**
	 * return final calories that needed per day.
	 */
	public double getfinalCalories() {
		return this.finalCalories;
	}
	
	/**
	 * return a food list that been add in that day
	 */
	public Map<String, Double> getFoodList() {
		return this.foodList;
	}
	
	/**
	 * Update a new list of food.
	 */
	public void setFoodList(Map<String, Double> foodList) {
		this.foodList = foodList;
	}
	/**
	 * Update final calories.
	 */
	public void setfinalCalories(double finalCalories) {
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
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * Set a new height.
	 */
	public void setHeight(int height) {
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
	public void setCaloriesNeeded(double caloriesNeed) {
		this.caloriesNeeded = caloriesNeed;
	}
	
	/**
	 * Set a calories that eaten that day.
	 */
	public void setCalories(double calories) {
		this.calories = calories;
	}
}
