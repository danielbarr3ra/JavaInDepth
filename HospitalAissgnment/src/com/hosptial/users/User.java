package com.hosptial.users;

public class User {

	private long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private boolean isInsured;
	private HealthInsurancePlan insurancePlan;
	
	private int age;
	private boolean isSmoking;
	
	public boolean isSmoking() {
		return isSmoking;
	}
	public boolean setSmoking(boolean isSmoking) {
		return this.isSmoking =  isSmoking;
	}

	public boolean isInsured() {
		return isInsured;
	}

	public void setInsured(boolean isInsured) {
		this.isInsured = isInsured;
	}

	public HealthInsurancePlan getInsurancePlan() {
		return insurancePlan;
	}

	public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	// add rest of the variables

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}