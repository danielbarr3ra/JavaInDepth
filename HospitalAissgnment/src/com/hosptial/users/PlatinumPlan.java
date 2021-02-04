package com.hosptial.users;

public class PlatinumPlan extends HealthInsurancePlan {
	PlatinumPlan() {
		setCoverage(0.9);
	}

	@Override
	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		// TODO Auto-generated method stub
		return 8.0 / 100.0 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}
}
