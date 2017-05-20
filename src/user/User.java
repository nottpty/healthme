package user;

import calories.CalculateCalories;

public class User {

	// activity is a daily life activity
	private String name, gender, activity;
	
	//waistcircum
	private double weight, height, waistcircum;
	
	// unit is Kcal
	// references : https://authoritynutrition.com/how-many-calories-per-day/
	private int calories, caloriesNeeded, age;
	
	public User(String name, String gender, String activity, int age) {
		this.name = name;
		this.gender = gender;
		this.activity = activity;
		this.age = age;
	}
	
	
	public int caloriesNeeded() {
		CalculateCalories cal = new CalculateCalories();
		caloriesNeeded = cal.calculateCal(gender, age, activity);
		return caloriesNeeded;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCalories() {
		return this.calories;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getAge() {
		return this.age;
	}
	
	public double getWaist() {
		return this.waistcircum;
	}
	
	public String getActivity() {
		return this.activity;
	}
	
	public int getCaloriesNeeded() {
		return this.caloriesNeeded;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setGender(String name) {
		this.gender = gender;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setWaist(double waist) {
		this.waistcircum = waist;
	}
	
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	public void setCaloriesNeeded(int caloriesNeed) {
		this.caloriesNeeded = caloriesNeed;
	}
}
