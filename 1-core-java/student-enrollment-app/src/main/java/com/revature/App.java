package com.revature;

import java.util.Arrays;
import java.util.Scanner;

import com.revature.models.Student;

public class App {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		run();
		
	}
	
	static void run() {
		

		// step 1. prompt the user how many students to enter
		System.out.println("How many students are you entering into the DB?");
		
		// step 2. grab the capacity that the user entered and build an array to hold student objects
		int numOfStudents = scan.nextInt(); // 
		
		Student[] students = new Student[numOfStudents]; // [ __ __ __ ] 
		
		// let's print out the student array toString() BEFORE we start intialize it
		System.out.println("This is what's inside the students array with " + numOfStudents + " places.");
		System.out.println(Arrays.toString(students));
		
		
		// step 3. make a for loop to iterate over each *empty* student object within the instantiated array
		for (int i=0; i < students.length; i++) {
		
			// for each element ask the user for firstname, last name, and grade year
			System.out.println("Please enter the first name");
			String firstName = scan.next();
			
			System.out.println("Please enter the last name");
			String lastName = scan.next();
			
			System.out.println("Enter the student's grade year:\n1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior");
			int gradeYear =  scan.nextInt();
			
			// for each empty element call the student constructor. because we have the data to fill the constructor
			Student s = new Student(firstName, lastName, gradeYear);
			
			// assign index i to the new Student object within the students array.
			students[i] = s;
		}
		
		// let's print out the student array toString() AFTER we initialize it
		System.out.println("This is what's inside the students array with " + numOfStudents + " places.");
//		System.out.println(Arrays.toString(students)); // Arrays class provides us utility methods to manipulate arrays
		
		//for each Student object within the Student array, call sysout(student.toString());
		for (Student s : students) {
			// s represents the individual Student Object within the array we're iterating over
			System.out.println(s.toString());
			s.enroll();
		}
		
	}

}
