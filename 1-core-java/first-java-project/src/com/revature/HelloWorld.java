package com.revature;

/**
 * A package in Java is used to group related classes. Think of it as a folder
 * in a file directory. We use packages to avoid name conflicts, and to write a
 * better maintainable code. Packages are divided into two categories:
 * 
 * + Built-in Packages (packages from the Java API) + User-defined Packages
 * (create your own packages)
 */

// This is a single line comment! The compiler won't pick up on it

/*
 * This is a multi-line comment - great for documentation! ctrl + makes it
 * larger, ctrl - makes text smaller
 */
public class HelloWorld {

	// main + ctrl + space, enter
	/**
	 * In any Java Program the main() method is the entry point from where the
	 * compiler starts program execution.
	 * 
	 * @param args ... represents commands that could follow the class name when we
	 *             call the "java" execution command to execute the bytecode.
	 * 
	 *             We will talk later about what it means to be "public", "static",
	 *             and "void"....
	 */
	public static void main(String[] args) {

		// sysout + ctrl + space....
		System.out.println("Hello World from the IDE!");

		// alt + shift + x, j (for windows!)

		boolean isCool = true; // boolean 1 bit representing true or false values (0 or 1)
		byte reallySmallNumber = 127; // 8 bits ( 1 byte) or reserved memory -> max value is 127, min value is - 128
		short shortNumber = 32_767; // 16 bits (2 bytes) of reserved mem
		char letter = 'h'; // 16 bits of memory that represent a character or an ASCII chracter's numeric
							// value

		int standardNum = 10_000_000; // 32 bits of reserved mem (4 bytes)
		float lessPreciseDouble = 93.2f; // 32 bits of mem, allows to make decimal, but its less precise than double

		double decimal = 10_000_000.02; // 64 bits of memory (8 bytes)
		long bigNumber = 1234567875758484L; // 64 bits of reserved mem - no decimal

		/**
		 * Casting
		 * 
		 * Type Casting is used to convert objects or variables of one type into another
		 * 
		 * Widening Casting (Implicit) - happens automatically - Automatic Type
		 * Conversion you can assign a smaller primitive type to a larger type refernce
		 * variable
		 * 
		 * Narrowing Casting (Explicit) - you need explicit conversion. Larger type
		 * convert to a smaller reference type
		 */

		byte a = 40; // IMPLICIT CASTING (WIDENING CASTING)
		short b = a; // we reassigned b to be equal to the value of a
		
		int c = b; // int is larger than short, no problem!
		double d = c;
		
		double myDub = 900.9;
		int myInt = (int) myDub; // EXPLICIT casting (narrowing)
		// transforming a large data type into a smaller one
		
		// sysout + ctrl + space
		System.out.println(myInt);
		
		String word = "spongebob";
		
		// What is the maximum value of int?
		
		// Wrapper class 
		Integer intObj1 = new Integer(20); // this creates (instantiates) a new object with the value of 20
		Integer intObj2 = new Integer("20");
		
		Double dubObj = new Double(32.09);
		
		System.out.println("The maximum value of an int is " + Integer.MAX_VALUE); // static member (globally available)
		
		// object equality
		System.out.println("Are intObj1 and intObj2 equal in value? " + intObj1.equals(intObj2));
		
		// how do we test that they share the same address in memory?
		System.out.println("Do intOb1 and intObj2 share the same address in memory? AKA are they the same obj? " + (intObj1 == intObj2));
		
		int x = (2 + 2);
		int y = 4;
		
		int z = 42;
		int w = 42;
		
		System.out.println( w == z); // true;
		
		System.out.println("Does (2 + 2) equal 4? " + (x == y) );
		
		// when it comes to objects, .equals() compares value, and == compares address in memory (heap)
		
	}

}
