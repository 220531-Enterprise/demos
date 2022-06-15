package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CrimeDao;
import com.revature.dao.SuperPrisonDao;
import com.revature.dao.SuperVillainDao;
import com.revature.models.Crime;
import com.revature.models.SuperPrison;
import com.revature.models.SuperVillain;

public class App {
	
	public static void main(String[] args) {
		
		System.out.println("Starting application");
		
		// Typically you call the Service layer, but
		// we're going to call the DAO directly
		
		// 1. INstantiate a Crime obj
		Crime c1 = new Crime("Time Manipulation", "freezin' time robbin' banks");
		Crime c2 = new Crime("Freezey Power", "cover the city in ice");
		Crime c3 = new Crime("Arson", "setting the city ablaze");
		
		// 2. persist it to the DB
		CrimeDao cdao = new CrimeDao();
		
		cdao.insert(c1);
		cdao.insert(c2);
		cdao.insert(c3);
		
		// Create a list of Crimes and add 2 of them to it
		List<Crime> crimesCommited = new ArrayList<Crime>();
		crimesCommited.add(c1);
		crimesCommited.add(c2);
		
		// Create a prison
		SuperPrison arkham = new SuperPrison("Arkham Asylum", "Gotham City", null);
		
		// create a supervillain
		SuperVillain joker = new SuperVillain("The Joker", "evilness", 1_000_000.05, crimesCommited, arkham);
		
		
		// insert both the superprison and the supervillain into the Db
		SuperPrisonDao spdao = new SuperPrisonDao();
		SuperVillainDao svilldao = new SuperVillainDao();
		
		spdao.insert(arkham);
		svilldao.insert(joker);
		
		System.out.println("Ending application");
	}

}
