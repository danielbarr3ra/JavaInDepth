package com.hosptial.users;


// You can ignore this class. It just represents an Insurance Company
public interface InsuranceBrand {
	double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking);
}