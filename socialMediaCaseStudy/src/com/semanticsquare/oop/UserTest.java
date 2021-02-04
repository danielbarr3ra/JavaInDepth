package com.semanticsquare.oop;

public class UserTest {
	public void printUserType(User u) {
		u.printUserType();
	}

	public void approveReview(Staff s) {
		// s.approveReview();
		if (s instanceof Editor) {
			((Editor) s).approveReview();
		} else {
			System.out.println("Inavlid object passed");
		}
	}
 
	public static void main(String[] args) {

		//User staff = new Staff(3);
	}
}