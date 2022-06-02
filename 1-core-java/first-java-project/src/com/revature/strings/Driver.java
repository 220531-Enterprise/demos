package com.revature.strings;

public class Driver {

	public static void main(String[] args) {
		
		/**
		 * Strings are used to store a sequence of characters, but they're treated as objects
		 * .. because they come from the STRING class!
		 * 
		 * - (1) String Object created with the new keyword -> goes to the general heap.
		 * - (2) String literal created with " " like String word = "something". -> goes to the String Pool INSIDE the heap 
		 */
		
		String stringObj = new String("straight to the general heap we go");
		System.out.println(stringObj);
		
		String str1 = "Hello"; // this string literal is created and sent to the STRING POOL 
		String str2 = "Hello"; // the JVM checks if there is a similar string and str2 now points to the same string as str1
		
		System.out.println("Does str1 have the same value as str2? " + str1.equals(str2)); // YES!
		
		// does str1 and str2 point ot eh same location in memory?
		System.out.println("does str1 and str2 point ot eh same location in memory? " + (str1 == str2));

		
		// up to this point TWO objects have been created
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode()); // hashcodes are the same
		
		String stringObj2 = new String("Hello"); // this goes to the general heap!!!
		
		System.out.println("does stringObj2 and str1 point ot eh same location in memory? " + (stringObj2 == str2));
		// NO! Now there is a "Hello" string object in both the genral heap and the string pool
		
		// same hashcode but different places in memory
		System.out.println(stringObj2.hashCode());
		System.out.println(str1.hashCode());
		
		String str3 = "Hello World";
		String str4 = "Hello " + "World"; // when we try to build a new string literal 
		// instead of creating a NEW string literal in the String Pool, str4 will point to the same object as str3
		
		System.out.println(str3 == str4); // TRUE! because + is smart 
		
		String str5 = "Hello";
		String str6 = str5 + " World"; // this is a mutation - this is equivelent to creting a new String object in the
									   // gen heap String str6 = new String("Hello World");
		
		System.out.println(str3 == str6); // FALSE 
		// to send a string in the gen heap to the string pool you use intern() method
		
		String str6inPool = str6.intern(); // now str6inPool is in the string pool
		
		// now, is str3 == to str6inPool?
		System.out.println(str3 == str6inPool); // str6inPool points to same object now
		
		/**
		 * String API
		 * 
		 * - concat()
		 * - substring()
		 * - charAt()
		 * - split()
		 * - isEmpty()
		 * - length()
		 */
		String newStrObject = str6inPool.concat("some-garbage"); // sent to the gen heap
		System.out.println(newStrObject);
		// we are calling the toString() method of whatever object we pass through when we call System.out.println
		
		String test = "The quick brown fox jumped over the lazy dog";
		String chopped = test.substring(5);
		System.out.println(chopped);
		
		System.out.println(test);
		

		// These are mutable versions of the String class
		// StringBuffer - thread safe and slower (synchronized nature)
		// StringBuilder - NOT thread safe and faster
		
		
		StringBuilder sBuild = new StringBuilder("Hello");
		sBuild.append(" ");
		sBuild.append("World");
		
		System.out.println(sBuild);
		
		String buildToString = sBuild.toString(); // set as a string (in the general heap)
		String sbInPool = buildToString.intern(); // send it to the string pool
		
		System.out.println(sbInPool == str6inPool);

		
	}

}
