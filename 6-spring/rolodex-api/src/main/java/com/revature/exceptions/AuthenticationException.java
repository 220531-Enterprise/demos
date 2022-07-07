package com.revature.exceptions;

public class AuthenticationException extends RuntimeException{

	public AuthenticationException() {
		super("Invalid username/password");
	}

	public AuthenticationException(String message) {
		super(message);
	}

}
