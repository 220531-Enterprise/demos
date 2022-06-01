package com.revature.accessmods;

public class ClassB {

	public static void main(String[] args) {

		// instantiate an object of the type ClassA
		ClassA classAObj = new ClassA();

		// no problem accessing all of the fields
		// EXCEPT THE PRIVATE FIELD
		System.out.println(classAObj.publicField);
		// System.out.println(classAObj.privateField);
		System.out.println(classAObj.defaultField);
		System.out.println(classAObj.protectedField);

	}

}

// you can have multiple classes in the same file, 
// but only ONE public class
class ClassC {
	
	
}