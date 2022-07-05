package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;
import com.revature.services.SportMotivationService;

@Component // footballCoach -  default naming of a bean is the class in camelCase
public class FootballCoach implements Coach{
	
	@Value("${coach.email}")
	private String email;
	
	@Value("The Jets")
	private String teamName;
	
	// Use the #{} for calculated expressions
	@Value("#{34 + 12}")
	private int someCalculatedValue;
	
	private MotivationService motivationService;
	
	public FootballCoach() {
		System.out.println("FootballCoach no-args constructor invoked!");
	}
	
	private void customInit() {
		System.out.println("FootballCoach.customInit() method invoked!");
	}
	
	private void customDestroy() {
		System.out.println("FootballCoach.customDestroy() method invoked!");
	}
	
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
	
	/**
	 * @Autowired marks a Constructor, Setter method, Properties and Config() method
	 *            as to be autowired; that is ‘injecting beans'(Objects) at runtime
	 *            by Spring Dependency Injection mechanism.
	 *            
	 *            @Inject (JEE annotation, which is functionally similar to Spring's @Autowired)
	 */
	@Autowired	
	public void setMotivationService(SportMotivationService motivationService) {
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
