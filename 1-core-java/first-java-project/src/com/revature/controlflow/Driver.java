package com.revature.controlflow;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
//		
//		// Instantiate a scanner whose sole purpose is to read from the console
//		Scanner scan = new Scanner(System.in);
//
//		// prompt the user to enter their name
//		System.out.println("Please type your name");
//		
//		// capture their input as a String type
//		String name = scan.next(); // Strings are NOT primitive
//		
//		// prompt the user to enter the weather degrees outside in fareignheight
//		System.out.println("How's the weather (in degrees)?");
//		
//		// capture that value as an int 
//		int temp = scan.nextInt();
//			
//		scan.close();
		// print it all out to the console
//		System.out.println("Your name is " + name + " and the weather is " + temp);
		
		/**
		 * 3 Main types of If/Else statements statements
		 * 
		 * if / else
		 * if / else if 
		 * ternary operator
		 */
		
		// if the weather is < 32, say "It's freezing!!"
		
		// if the weather is > 32 and less than 60, say "it's kinda chilly"
		
		// otherwise the weather is great
//		
//		if (temp < 32) {
//			System.out.println("It's freezing!");
//			// keep in mind this is silly 
//		} else if ( temp == 32 || temp <= 60) { //   this operator is an OR statement  || , there is also a && which means "and"
//			System.out.println("it's kind of chilly");
//		} else {
//			System.out.println("The weather's fine...");
//		}
		
		// Switch Statement (another form of control flow asides from if/else statements
		int monthNum = 7;
		
		switch(monthNum) {
	
		// in the case that monthNum is equal to 6...
		case 6: 
			System.out.println("The month is June");
			break;
		// in the case that monthNum is equal to 6...
		case 7:
			System.out.println("The month is July");
			break;
		default:
			System.out.println("Lazy dev, sorry didn't plan for so many months");
			
		}
		
		/**
		 * Switch Case
		 * 
		 * If/ Else 
		 * 
		 * Tomorrow: Ternary Operators (total flex for if/else statements) 
		 * while loops
		 * do-while loops
		 * for loops
		 */
		
		// You only use ternary operators if there is a if/else condition
		boolean isHungry = true;
		
		// print out either LET's EAT!!! or pass..not hungry 
		
		System.out.println((isHungry) ? "LET'S EAT!!!!" : "Pass..not hungry");
		
		int hungerLevel = 1;
		
		System.out.println(( hungerLevel >= 5 ) ? "I'M HUNGRY!!!!!!" : "not hungry ");
		
		
		String word = (( hungerLevel >= 5 ) ? "I'M HUNGRY!!!!!!" : "not hungry ");
		
		Object o1 = new Object();
		Object o2 = new Object();
		
		
		if (o1.equals(o2)) { // false
			System.out.println("2 empty objects are equal!");
		} else { 
			System.out.println("No.... the 2 empty pobjects aren't equal in value");
		}
		
		// while (condition is true) do whatever is inside the brackets
//		while (true) {
//			
//			System.out.println("looping!");
//			
//		}
		
		int counter = 10;
		
		while (counter > 0) {
			System.out.println("The value of counter is.... " + counter);
			counter --; // decrease the counter by 1
			
		}
		
		boolean keepGoing = false;
		
		do {
			System.out.println("in the do while");
		} while (keepGoing); // assesses that this is false and quits
		
		
		// for loops....
		
		/*
		 * Statement 1 is where to begin
		 * statement 2 is a condition that determines whether to keep going
		 * Statement 3 is executed everytime (after) the code block executes
		 */
		
		// let's count to 10 from zero
		for (int i=0; i<=10; i++) {
			
			System.out.println("The value of i is " + i);
			
		}
		

	}

	
	
	
	
	
	
	
	
}
