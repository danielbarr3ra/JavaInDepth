package com.hosptial.users;

public class Billing {

	public static double[] computePaymentAmount(Patient patient, double amount) {
		double[] payments = new double[2];
		HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
		if (patientInsurancePlan != null) {
			payments[0] = amount * patientInsurancePlan.getCoverage();
			if (patientInsurancePlan instanceof PlatinumPlan) {
				double discount = 50.0;
				payments[1] = ((amount-payments[0]-discount)>0?(amount-payments[0]-discount):0);
			} else if (patientInsurancePlan instanceof GoldPlan) {
				double discount = 40.0;
				payments[1] = ((amount-payments[0]-discount)>0?(amount-payments[0]-discount):0);
			} else if (patientInsurancePlan instanceof SilverPlan) {
				double discount = 30.0;
				payments[1] = ((amount-payments[0]-discount)>0?(amount-payments[0]-discount):0);
			} else if (patientInsurancePlan instanceof BronzePlan) {
				double discount = 25.0;
				payments[1] = ((amount-payments[0]-discount)>0?(amount-payments[0]-discount):0);
			}
		} else {
			double discount = 20.0;
			payments[0] = 0;
			payments[1] = ((amount - discount)>0)?(amount - discount):0;
		}

		return payments;
	}
}