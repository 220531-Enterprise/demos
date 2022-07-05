package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component // default name of a sterotype annotated bean is the camelCase version of the class - ("baseballCoach")
public class BaseballCoach implements Coach {
	
	private MotivationService motivationService;
	
	@Autowired // this is not actually necessary - Spring detects this as the way to fulfill dependencies autoamtically
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
