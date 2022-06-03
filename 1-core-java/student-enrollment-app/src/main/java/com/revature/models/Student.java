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
	private double tuitionBalance = 0; // every student starts with $0 tuition balance initializetiong

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
		
		// involve a scanner, so when the method is called, we're porm[pted to add the classes
		
		// Step. 1 Create an empty LinkedList of courses to add
		List<Course> coursesToAdd = new LinkedList<>();
		
		// 2. opn up a while loop and have the user click q to quit
		boolean isDone = false;
		
		while(!isDone) { // ! indicates opposite of true .. as long as isDone is FALSE
			// 3prompt the user top enter a course name
			System.out.println("Enter the name of a course to enroll in");
			// 3a. capture that string 
			String courseName = scan.next();
			// if the course name is == q, quite from the loop
			if (!courseName.equalsIgnoreCase("q")) {
				
				Course course = new Course(courseName);
				courses.add(course);
				
				tuitionBalance += Course.COST_OF_COURSE; // increase by $600
				
				scan.nextLine();
			} else {
				System.out.println("===== quitting the program ======");
				isDone = true; // break from the loop
			}
		
		}
		
		// adjust the student object's courseList
		this.courses = coursesToAdd; // add it to the Student Object's course list
		
		System.out.println("ENROLLED IN: " + courses.toString());
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
