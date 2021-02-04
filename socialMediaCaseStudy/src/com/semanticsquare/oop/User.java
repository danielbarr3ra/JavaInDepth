package com.semanticsquare.oop;

public class User {
	public int id = 1;
	public String userType = "User";
	
	public User() {
		System.out.println();
	}
	public void printUserType() {
		System.out.println("User");
	}

	public void saveWebLink() {
		System.out.println("User: saveWebLink");
		postAReview("");
		staticMethod();
	}

	public Review postAReview(String reviewText) {
		System.out.println("User: postAReview");
		Review review = new Review(reviewText);
		return review;
	}
	public static void staticMethod() {
		System.out.println("Static method in User");
	}
	public void displayUserInfo() {
		System.out.println(this);
	}
	public String toString() {
		return ("overrid poString \n" + "id:  + id\n" + "type:  + userType");
	}
	
	public final void finalMethod() {}
	
}