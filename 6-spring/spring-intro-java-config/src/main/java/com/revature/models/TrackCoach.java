package com.revature.models;

import com.revature.services.MotivationService;

public class TrackCoach implements Coach {
	
	// Gross. Tight Coupling
//	private MotivationService motivationService = new MotivationService();
	
	private MotivationService motivationService;
	
	// Constructor Injection - in Spring is recommended for
	// objects w/ MANDATORY dependencies
	public TrackCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	
	@Override
	public String getMotivation() {
		// TODO Auto-generated method stub
		return "The Track coach says: " + motivationService.getMotivation();
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Today's workout: Run a 5k in 30 minutes";
	}

	@Override
	public MotivationService getMotivationService() {
		return this.motivationService;
	}

}
