package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Dao1;

@Service
public class Service1 {
	
	// call on the DAO1
	@Autowired 
	private Dao1 dao1;

	public String calculateSomething() {
		// some rigorous business logic
		return dao1.retrieveSomething(); // call to the Dao layer
	}
	
}
