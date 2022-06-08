package com.revature.exceptions;

public class RegisterUserFailedException extends RuntimeException {

	// whenever this exception is thrown, we can pass a message
	public RegisterUserFailedException(String message) {
		super(message);
	}

	// alt + shift + s pops up the constructor & boilerplate code menu 
	// or right click > Source > generate constructors from superclass
}
