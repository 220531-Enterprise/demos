package com.revature;

import com.revature.dao.CrimeDao;
import com.revature.models.Crime;

public class App {
	
	public static void main(String[] args) {
		
		System.out.println("Starting application");
		
		// Typically you call the Service layer, but
		// we're going to call the DAO directly
		
		// 1. INstantiate a Crime obj
		Crime c1 = new Crime("Time Manipulation", "freezin' time robbin' banks");
		
		// 2. persist it to the DB
		CrimeDao cdao = new CrimeDao();
		
		cdao.insert(c1);
		
		System.out.println("Ending application");
	}

}
