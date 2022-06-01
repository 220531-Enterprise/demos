package com.revature.accessmods;

/**
 * 4 Pillars of OOP
 * 
 * Abstraction
 * Polymorphism
 * Inhertiance
 * Encapsulation
 * 
 * Encapsulation is a mechanism in which data and methods can 
 * be wrapped together in a single unit.  We can restrict access to this data
 * by using access modifiers.
 *
 */
public class ClassA {
	
	// these are instance variables! (they're not static) - every object instantiated from this class with have these 4 props
	public int publicField = 1;
	private int privateField = 2;
	int defaultField = 3; // absence of an access modifier is DEFAULT
	protected int protectedField = 4;
	
	/*
	 * public = visible throughout the entire project
	 * 
	 * private = visible within the class ONLY 
	 * 
	 * default = visible within the same package
	 * 
	 * protected = visible (like default) except also 
	 * visible to child classes even if those child classes are in
	 * 			   other packages.
	 */
	
	public static void main(String[] args) {
		
		// instantiate an object of ClassA!
		ClassA obj1 = new ClassA(); // this is a no-args or DEFAULT constructor
		
		// no problem accessing all of the fields
		System.out.println(obj1.publicField);
		System.out.println(obj1.privateField);
		System.out.println(obj1.defaultField);
		System.out.println(obj1.protectedField);
		
	}
	
	
	
	
	
}
