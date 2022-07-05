package com.revature.services;

import org.springframework.stereotype.Service;

/**
 * This bean is responsible for business logic
 */
@Service // Stereotype Component - Service, Repository, Controller 
public class MotivationService {

	public MotivationService() {
		System.out.println("MotivationService no-args constructor invoked!");
	}
	
	public String getMotivation() { 
		
		return "Don't quit. Suffer now and live the rest of your life a champion";
		
	}
	
}
