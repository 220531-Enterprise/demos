package com.revature.pojos;

public class Artist extends Person {
	
	// all of this is abstracted
	// private String name
	// private int age

	// An Artist is a TYPE OF Person - we inherit the constructor and all its methodsa and properties
	public Artist(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Abstraction
	 * 
	 * Abstraction is the process of obfuscating data that is unecessary for the user 
	 * to view.
	 * 
	 * This is typically achieved with Abstract classes and interfaces
	 */

}
