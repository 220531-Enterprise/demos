package com.revature.models;

import com.revature.services.MotivationService;

public interface Coach {

	String getMotivation();
	String getDailyWorkout();
	MotivationService getMotivationService();
	
}
