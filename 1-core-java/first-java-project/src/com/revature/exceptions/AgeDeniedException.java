package com.revature.exceptions;

// If we want to create a custom exception we extend runtime exception
public class AgeDeniedException extends RuntimeException{ // CHECKED vs UNCHECKED exceptions 

	// UNCHECKED Exceptions happen at runtime .. aka Runtime Exceptions
	public AgeDeniedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
