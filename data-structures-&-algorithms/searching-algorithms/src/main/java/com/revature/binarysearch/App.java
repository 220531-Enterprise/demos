package com.revature.binarysearch;

public class App {

	public static void main(String[] args) {
	
		int[] arr = {1, 23, 44, 51, 67, 89, 99, 101};
		int x = 99;
	
		System.out.println(binarySearch(arr, x));
		
	}
	
	/**
	 * 
	 * @param arr represents a sorted array of integers=
	 * @param x represents the integer we're searching for
	 * @return the index that x lies at
	 */
	static int binarySearch(int[] arr, int x) {
		
		// capture the min & max index
		int min = 0; 
		int max = arr.length -1;
		
		// set up a loop that continues
		// as long as the minimum is <= max
		while (min <= max) {
			
			System.out.println("."); // how many operations it takes to accomplish this
			
			// find the mid way point
			int mid = (min + max) / 2;
			
			// check if the target value is less than or greater than the element AT  midway point
			if (x < arr[mid]) {
				
				// discard the entire Right Hand Side (RHS)
				// set a new max
				max = mid - 1;
				
			} else if ( x > arr[mid]) {
				
				// discard the entire left hand side and 
				// reassign the min index
				min = mid + 1;
				
			} else {
				return mid;
			}
		}
		
		return -1; // target can't be found;
	}
	

}
