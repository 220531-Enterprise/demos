package com.revature.models;

import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;
import com.revature.services.SportMotivationService;

@Component
public class BaseballCoach implements Coach {

	private MotivationService motivationService;

	public BaseballCoach(SportMotivationService motivationService) {
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
