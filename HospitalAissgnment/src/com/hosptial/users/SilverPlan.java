package com.hosptial.users;

public class SilverPlan extends HealthInsurancePlan {
	SilverPlan(){
		setCoverage(0.7);
	}

	@Override
	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		// TODO Auto-generated method stub
		return 6.0 / 100.0 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}
}
