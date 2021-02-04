package com.hosptial.users;

public class Staff extends User {
	private long stafId;
	private int yearsOfExperience;
	private String description;
	private double salary;
	
	
	public long getStafId() {
		return stafId;
	}
	public void setStafId(long stafId) {
		this.stafId = stafId;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
