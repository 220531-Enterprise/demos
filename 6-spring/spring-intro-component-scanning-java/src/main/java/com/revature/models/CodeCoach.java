package com.revature.models;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component
public class CodeCoach implements Coach {
	
	private MotivationService motivationService;
	
	// CodeMotivationService could also be passed
	public CodeCoach(@Qualifier("codeHypeService")MotivationService service) {
		System.out.println("CodeCoach constructor invoked!");
		this.motivationService = service;
		
	}

	@Override
	public String getMotivation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MotivationService getMotivationService() {
		// TODO Auto-generated method stub
		return null;
	}

}
