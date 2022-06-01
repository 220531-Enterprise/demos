package com.revature.otherpackage;

/**
 * 2 types of imports built in & user-defined
 */
import com.revature.accessmods.ClassA;

public class ClassE extends ClassA{

	
	public static void main(String[] args) {
		
		// instleantiate an object of ClassA!
		ClassE obj1 = new ClassE(); // this is a no-args or DEFAULT constructor
		
		// no probm accessing all of the fields
		System.out.println(obj1.publicField);
//		System.out.println(obj1.privateField);
//		System.out.println(obj1.defaultField);
		
		// because ClassE extends ClassA, we can access
		// the protected Field, even though it's in 
		// another package
		System.out.println(obj1.protectedField);
		
	}

}
