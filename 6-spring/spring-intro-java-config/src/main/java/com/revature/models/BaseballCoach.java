package com.revature.models;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach {
	
	// Gross. Tight Coupling
//	private MotivationService motivationService = new MotivationService();
	
	private MotivationService motivationService;
	
	// Constructor Injection - in Spring is recommended for
	// objects w/ MANDATORY dependencies
	public BaseballCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	
	@Override
	public String getMotivation() {
		// TODO Auto-generated method stub
		return "The baseball coach says: " + motivationService.getMotivation();
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Today's workout: Spend 30 minutes on batting practice";
	}

	@Override
	public MotivationService getMotivationService() {
		return this.motivationService;
	}

}
