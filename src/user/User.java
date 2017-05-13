package user;

public class User {

	// activity is a daily life activity
	private String name, gender, activity;
	
	//waistcircum
	private double weight, height, waistcircum;
	
	// unit is Kcal
	// references : https://authoritynutrition.com/how-many-calories-per-day/
	private int calories, caloriesNeeded, age;
	
	public User(String name) {
		this.name = name;
	}
	
	public int caloriesNeeded(String gender, double weight, double height, int age, String activity) {
		Calories cal = new Calories();
		caloriesNeeded = cal.calculateCal();
		return caloriesNeeded;
	}
	
	public String getName() {
		return this.name;
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
	
	public void setAge(double age) {
		this.age = age;
	}
	
	public void setWaist(double waist) {
		this.waistcircum = waist;
	}
}
