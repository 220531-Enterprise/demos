package com.revature.models;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Student {
	
	public static int GLOBAL_ID = 1000; // increment this everytime a student is created
	private static Scanner scan = new Scanner(System.in);
	
	private String firstName; // I'm declaring
	private String lastName;
	private int gradeYear; // 1 - Freshman , 2 - sophomore, etc.
	private String studentId; // this will be a concatenated value 
	private List<Course> courses = new LinkedList<Course>();
	private double tuitionBalance = 0; // every student starts with $0 tuition balance (we're initializing)

	// constructor
	public Student(String firstName, String lastName, int gradeYear) {
		
		super(); // calls the Object class
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeYear;
		
		setStudentId(); // invokes the method and sets ID
		System.out.println(firstName + " " + lastName + " " + gradeYear + " " + " " + studentId);
		
	}
	
	private void setStudentId() {
		
		// incremenent the GlobalID
		GLOBAL_ID++;
		this.studentId = gradeYear + "" + GLOBAL_ID;
	
	}
	
	public void enroll() {
		
		// step 1. Create an empty arraylist of courses to add
		List<Course> coursesToAdd = new LinkedList<Course>();
		
		// step 2. open up a while loop and have the user click q to quit
		boolean isDone = false;
		
		while (!isDone) { // as long as isDone == false
			
			// step 3. prompt the user to enter a course name
			System.out.println("Enter the name of a course to enroll in:");
			
			// step 3a. capture that string in an String variable called name
			String courseName = scan.next(); // we need to create a scanner in this class
			
			if (!courseName.equalsIgnoreCase("q")) { // if the user puts in an uppercase Q? equals ignore case can handle it
					
				// step 4. use that name to build a course Object
				Course course = new Course(courseName);
				
				// step 4a add it to the courses to add list
				coursesToAdd.add(course);
				
				// step 5. increase the Student's balance property by 600 per course
				tuitionBalance += Course.COST_OF_COURSE; // tution balance is equal to tution balance + the static cost of course (600)
				
				scan.nextLine(); // this is necessary to repeat the loop
				
			} else { // else if they wrote "q"
				
				System.out.println("===== quitting program =====");
				isDone = true;
			}
		
			
		}
		
		// step 6. set the student's course list equal to the course list that we create here
		this.courses = coursesToAdd; // this means the courses list 
		
		// step 7. print it all out!
		System.out.println("ENROLLED IN " + courses.toString());
		
	}
	
	// view balance
	public void viewBalance() {
		System.out.println("Your balance is equal to " + tuitionBalance);
	}
	
	
	// pay tution
	public void payTuition() {
		
		viewBalance();
		
		// 1. prompt enter payment amount
		System.out.println("Please enter a payament amount");
		
		// 2. capture the amount as a double
		double payment = scan.nextDouble();
		
		// 3.  subtract the amount that we capture from the objects tuition
		tuitionBalance -= payment;
		
		// 4.  print out thank you and show the payment amount again
		System.out.println("Thank you for your payment of " + payment);
		
		viewBalance();
	}
	


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getGradeYear() {
		return gradeYear;
	}


	public void setGradeYear(int gradeYear) {
		this.gradeYear = gradeYear;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	public double getTuitionBalance() {
		return tuitionBalance;
	}


	public void setTuitionBalance(double tuitionBalance) {
		this.tuitionBalance = tuitionBalance;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + gradeYear;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tuitionBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (courses == null) {
			if (other.courses != null)
				return false;
		} else if (!courses.equals(other.courses))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gradeYear != other.gradeYear)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (Double.doubleToLongBits(tuitionBalance) != Double.doubleToLongBits(other.tuitionBalance))
			return false;
		return true;
	}
	
	
	
}
