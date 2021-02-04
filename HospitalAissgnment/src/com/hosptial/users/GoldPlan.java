package com.hosptial.users;

public class GoldPlan extends HealthInsurancePlan {
	GoldPlan(){
		setCoverage(0.8);
	}

	@Override
	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		// TODO Auto-generated method stub
		return 7.0 / 100.0 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}
}
