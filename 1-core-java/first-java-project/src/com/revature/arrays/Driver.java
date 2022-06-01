package com.revature.arrays;

import java.util.Arrays;

/**
 * An array is a container object that contains elements of ONE type
 * 
 * An array is STATIC (not dynamic) - it can't increase or decrease in size)
 */
public class Driver {
	
	public static void main(String[] args) {
	
		// (1) declare the the type the array can hold
		int[] numbers; 
		
		// (2) initialize the capacity
		numbers = new int[10]; // creating the array object [ __ ___ ___ __ __ __ __ __ __ ]
			
		System.out.println(Arrays.toString(numbers)); // ctrl + shift + o
		
		// accessing elements
		// the last index will always be one less thatn the length of the array'

		
		
		// i want to access the 2nd element and set it to 42
		numbers[1] = 42;
		System.out.println(Arrays.toString(numbers)); // you are not mutating
		
		// use a for loop to loop through this array and assign each element to 100 * its index
		
		for (int i=0; i<numbers.length; i++) {
			
			numbers[i] = i * 100;
			
		}
		
//		System.out.println(Arrays.toString(numbers));
		// enhanced for loop
		for (int n : numbers) {
			System.out.println(n);
		}
		
		// how we print out the the 4th element
		System.out.println(numbers[3]);
		
	}
	
	

}
