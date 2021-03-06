package com.revature.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InteractiveArrays { // A Class is a blueprint for an object
								 // A class consists of States (properties) and Behaviors (methods)
	
	// static = global or class level
	// This scanner is a property that is used amongst the methods within the class
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
	
		int[] establishedArray = getIntegers(5);
		
		scan.close();
		
		System.out.println(Arrays.toString(establishedArray));
		
		// call the getAvg method on the establishedArray
		double avg = getAverage(establishedArray);
		
		System.out.println(avg);
	
	}
	
	
	/**
	 * Create a method that does the following
	 * 
	 * - static method (available at the class level - I don't need to instantiate the class to use the method)
	 * - return type will be int[]
	 * - prompt the user to enter x numbers
	 * - store each number in the array
	 */
	
	static int[] getIntegers(int capacity) {
		
		System.out.println("Please enter " + capacity + " numbers:");
		
		// initialize the array
		int[] arr = new int[capacity];
		
	
		// create a for loop to loop through the array
		// in each iteration we capture the user's input and save it to an element
		for (int i=0; i<arr.length; i++) {
			
			System.out.println("Enter the "+ (i+1) +  " number:");
			// capture the user input and set it to the array's element of that iundex
			arr[i] = scan.nextInt();
			
		}
		
		
		return arr;
	
	}
	
	/*
	 * CHALLENGE:
	 * Create a static method that takes in an int array as a parameter.  It must return the average of all
	 * the elements within the array. (Make its return type a double).
	 * 
	 * Once you create this method, call it within the main method, and print its return, after passing through
	 * the array that was returned by the getIntegers method.
	 * 
	 * BONUS: Can you create another method that prints out the array so we don't have to always call the Arrays.toString method?
	 */
	static double getAverage(int[] arr) {
		
		// I will need a for loop to iterate thru the entire array
		
		// I need to record a SUM (avg = sum of all ints / by number of elements)
		
		// I need to make sure I capture the LENGTH of the array (because that tells me the number of elements in the array
		
		double sum = 0; // initialized to 0 at first
		
		for (int i=0; i<arr.length; i++) {
			
			// grab the value of the element at index i and add it to a sum value
			// sum = sum + arr[i];
			sum += arr[i]; // short hand way of adding the value of the element to the sum	
			
		}
		
		double avg = sum / arr.length; // arr.length returns the number of elements in the array
		
		return avg;
	}
	
	
	static int sum(int x, int y) {
		return x + y;
	}
	

}
