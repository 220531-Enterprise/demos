package com.revature.scopes;

import com.revature.pojos.Employee;
import com.revature.pojos.Person;

/**
 * There are 4 scopes in Java
 * 
 * 1. Class Scope (Static/Global Scope)
 * 2. Instance Scope (the variables that belong to specific objects)
 * 3. Method Scope (variables confined to a respective method)
 * 4. Block Scope (think about the i variable that we use in a for loop, but can't access outside of the for loop)
 *
 * The term "field" refers to a static or instance scoped variable
 * The "Local Variable" refers to a method or a block scope 
 */
public class Driver {
	
	// instance level variable
	int z = 1_000_000;
	
	public static void main(String[] args) {
		
		System.out.println("The maximum age of all people everywhere is " + Person.MAX_AGE);
		
		Person p = new Employee("Larry", 25, "finance");
		// lLarry's name instance variable
		System.out.println("Larry's name is " + p.getName());
		System.out.println(p.MAX_AGE); // you can also call a static member from the instance, just not reccomended
		
		int b = 5;
		
		while (b > 0) {
			
			int result = b * b;			
			
			for (int i=0; i< 100; i++) {
				System.out.println(i);
			}
			
			break;
			
		}
		
		// we can't reach a variable that's block scoped from outside the block
		// System.out.println(result);
		
	}
	
	static int multiply(int x, int y) {
		// establishing method - lvevel variables
		int z = 100;
		
		return x * z * y;
		
	}
	
	
	

}
