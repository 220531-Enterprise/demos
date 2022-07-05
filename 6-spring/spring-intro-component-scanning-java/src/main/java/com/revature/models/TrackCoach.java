package com.revature.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;
import com.revature.services.SportMotivationService;

@Scope("prototype")
@Component("myCoach")
public class TrackCoach implements Coach {
	
	private MotivationService motivationService;

	public TrackCoach(SportMotivationService motivationService) {
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
