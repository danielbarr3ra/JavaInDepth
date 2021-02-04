package com.hosptial.users;

public class BlueCrossBlueShield implements InsuranceBrand {
	private long id;
	private String name;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {
		// TODO Auto-generated method stub
		double premium = 0;
		if (insurancePlan instanceof PlatinumPlan) {
			premium += (age > 55)? 200.0 :0;
			premium += (smoking)?  100.0 :0;
		} else if (insurancePlan instanceof GoldPlan) {
			premium += (age > 55)? 150.0 :0;
			premium += (smoking)?  90.0  :0;
		} else if (insurancePlan instanceof SilverPlan) {
			premium += (age > 55)? 100.0 :0;
			premium += (smoking)?  80.0  :0;
		} else if (insurancePlan instanceof BronzePlan) {
			premium += (age > 55)? 50.0 :0;
			premium += (smoking)?  70.0 :0;
		}
		return premium;
	}
	
}
