package com.hosptial.users;

public class BronzePlan extends HealthInsurancePlan{
	BronzePlan(){
		setCoverage(0.6);
	}

	@Override
	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		// TODO Auto-generated method stub
		return 5.0 / 100.0 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}
}
