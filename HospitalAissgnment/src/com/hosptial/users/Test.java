package com.hosptial.users;

public class Test {
 public static void main(String[] args) {
	 User staff = new User();                        
	 InsuranceBrand insuranceBrand = new BlueCrossBlueShield();           
	 HealthInsurancePlan insurancePlan = new PlatinumPlan(); 	 
	 insurancePlan.setOfferedBy(insuranceBrand);
	 staff.setInsurancePlan(insurancePlan);
	 System.out.println(insurancePlan.computeMonthlyPremium(5000, 56, true));

 }
}
