package com.revature.exceptions;

public class Driver {

	public static void main(String[] args) {
		
//		int x = 10;
//		int y = 2;
//		
//		System.out.println(divideEAFTP(x, y));
		try {
			ageChecker(18);
		} catch (AgeDeniedException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("We reached this line! Yay!");

	}
	
	// void does not return, just DOES something
	static void ageChecker(int age) {
		
		// if the age is under 21, throw an exception
		if (age < 21) {
			// BECAUSE this method throws an exception, we must handle it wherever we invoke the method
			throw new AgeDeniedException("Sorry your age is " + age + " which is under 21.");
			// throw keyword is used to create a custom exception 
		} else {
			System.out.println("Welcome!");
		}
		
	}
	
	
	// Look Before you Leap
	static int divideLBYL(int x, int y) {
		
		// IF y is NOT equal to 0, go ahead and return the quotient
		if (y != 0 ) {
			return x / y;
		} else {
			return 0;
		}
		// ELSE return 0....
		
	}

	// Easier to Ask for Forgiveness Than Permission (Exception Handling)
	static int divideEAFTP(int x, int y) { 
		
		try {
			return x / y;
		} catch (ArithmeticException e) {
			System.out.println("You cannot divide by zero!");
			return 0;
		} finally { // typically you use finally to close some resource
			System.out.println("The finally block will ALWAYS execute");
		}
		
		// what is the difference between final, finally and finalize()?
 		
	}
	
	
	
	static int divide(int x, int y) {
		
		return x / y;
		
	}

}
