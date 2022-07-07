package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Dao2;

@Service
public class Service2 {
	
	// call on the DAO2
	@Autowired 
	private Dao2 dao2;

	public String calculateSomething() {
		// some rigorous business logic
		return dao2.retrieveSomething(); // call to the Dao layer
	}
	
}
