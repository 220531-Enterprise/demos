package com.revature.pojos;

import java.util.Scanner;

public class App { // the name of the file always corresponds to the public class declared within it
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("This is the entry point of our simulation game....");
		
		System.out.println("Please press Y to create person or press Q to quit:");
		
		// capture user input in String format
		String input = scan.next();
		
		// check that value... if it's Y, create a Person object
		if (input.toUpperCase().equals("Y")) {
			
//			Person p1 = new Person(); // the default name will be "" and the age will be 0
			
			System.out.println("Please enter a name");
			String name = scan.next();
			
			System.out.println("Please enter an age");
			int age = scan.nextInt();
			
			System.out.println("Press 1 for them to be an employee, press 2 for them to be a artist");
			
			int choice = scan.nextInt();
			
			Person p1;
			
			if (choice == 1) {
				System.out.println("What dept do they work for?");
				String dept = scan.next();
				
				p1 = new Employee(name, age, dept);
			} else {
				p1 = new Artist(name, age);
			}
			
			p1.introduceSelf();
			System.out.println(p1);
			
		} else {
			System.out.println("Goodbye!");
			System.exit(0); // terminates the JVM and the exti status of 0 means
							// nothing went wrong
		}
		
		
		
		// if it's Q, quit the application
		
		
	}
	
}
