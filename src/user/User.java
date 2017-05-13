package user;

public class User {

	private String name, gender;
	private double weight, height, age, waistcircum;
	
	public User(String name) {
		this.name = name;
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
