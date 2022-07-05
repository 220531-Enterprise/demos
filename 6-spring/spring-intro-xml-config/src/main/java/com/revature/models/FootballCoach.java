package com.revature.models;

import com.revature.services.MotivationService;

public class FootballCoach implements Coach{
	
	private String email;
	private String teamName;
	private MotivationService motivationService;
	
	public FootballCoach() {
		System.out.println("FootballCoach no-args constructor invoked!");
	}

	// Setter Injection is an alternative to COnstructor injection
	// in Spring it's recommended to use setter injection with OPTIONAL dependencies

	@Override
	public String getMotivation() {
		return "The baseball coach says: " + motivationService.getMotivation();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	// Setter-based Dependency Injection 
	// Setter based DI is accomplished by the container calling setter methods on your
	// beans after invoking a no-argument constructor 
	public void setMotivationService(MotivationService motivationService) {
		System.out.println("FootballCoach.setMotivationService() invoked!");
		this.motivationService = motivationService;
	}

	@Override
	public String getDailyWorkout() {
		return "Today's workout: Sprints to the 40, 50, 60, 80, 100 yards lines.";
	}

	@Override
	public MotivationService getMotivationService() {
		// TODO Auto-generated method stub
		return motivationService;
	}

}
