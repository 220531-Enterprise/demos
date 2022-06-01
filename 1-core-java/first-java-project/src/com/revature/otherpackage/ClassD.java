package com.revature.otherpackage;

import com.revature.accessmods.ClassA;

public class ClassD {

	public static void main(String[] args) {

		// instantiate class A

		// instantiate an object of ClassA!
		ClassA obj1 = new ClassA(); // this is a no-args or DEFAULT constructor

		// I can ONLY access the public field
		System.out.println(obj1.publicField);
//		System.out.println(obj1.privateField);
//		System.out.println(obj1.defaultField);
//		System.out.println(obj1.protectedField);

	}

}
