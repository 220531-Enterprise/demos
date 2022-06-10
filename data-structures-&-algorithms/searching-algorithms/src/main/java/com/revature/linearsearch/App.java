package com.revature.linearsearch;

public class App {

	public static void main(String[] args) {
		
		int[] arr = {1, 23, 44, 51, 67, 89, 99, 101};
		int x = 99;
		
		linearSearch(arr, x);
			
	}
	
	/**
	 * Linear Time Complexity O(n) -- the amount of steps to find
	 * a target is equivelent to the number of input
	 * 
	 * @param arr represents a sorted array of integers=
	 * @param x represents the integer we're searching for
	 * @return the index that x lies at
	 */
	static int  linearSearch(int[] arr, int x) {
		
		// open a for loop and loop throughout the entire  array
		for (int i=0; i < arr.length; i++ ) {
		
			// check if the elements at that index is equal to the target
			if (arr[i] == x) {
				
				// if line 28 is NOT true, we skip right down to line 35
				System.out.println("The index of " + x + " is " + i);
				return i; // if we return here, we DON'T hit sysout
			} 
			
			System.out.println("."); // printing out a . for every step this takes
	
		
		
		}
		
		// return -1 if we don't find it
		return -1;
	}

}
