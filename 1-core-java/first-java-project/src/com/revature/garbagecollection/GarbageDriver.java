package com.revature.garbagecollection;

// final over a class means that it can't be extended
public final class GarbageDriver {

	// the final keyword ensures that a variable can NEVER be reassigned a new
	// value
	final static int numThatNeverChanges = 9000;
	int someNum; // instance variable

	public static void main(String[] args) {

		// Even though Java i derived from C it was designed to improve
		// upon C by implementing automatic memory management
		// Garbage Collector (a Daemon thread) - non-deterministic meaning you can't force it, 
		// but encourage it instead with System.gc();

		System.out.println("Instantiateing a garbage Driver Object");

		GarbageDriver gd1 = new GarbageDriver();
		gd1.someNum = 42;
		
		
		System.out.println("Instantiateing another Garbage driver object");
		GarbageDriver gd2 = new GarbageDriver();
		gd2.someNum = 2;
		
		gd1 = gd2; // the object created on line 19 gets sent to the garbage collector because it's now unreferenced
		gd2 = null; // the object created on Line 24 gets sent to the collector! Because it's now unreferenced
		
		// WHEN IS AN OBJECT ELIGIBLE FOR GARBAGE COLLECTION?? When it's no longer referenced
		
		// You can encourage the Garbage Collector remove unreferenced objects from the heap by calling the
		// System.gc() method. Garbage Collection is non-deterministic meaning it can't be forced, but it
		// can be encouraged
		System.gc();
		
		for (;;) {
			System.out.println("...");
			// this is just a loop to repeat forever
		}
	}
	
	// what is the difference between final, finally, finalize()!?
	
	// The finalize() method is invoked when the object is removed from the heap by the garbage collector
	@Override
	protected void finalize() { // finalize() comes from the Obkject.java class!
		
		System.out.println("The object's finalize() method was called and it was removed from the heap!!!!");
		System.out.println("....................................................");
		System.out.println("....................................................");
		System.out.println("....................................................");
		System.out.println("....................................................");
		System.out.println("....................................................");
		System.out.println("....................................................");
		System.out.println("....................................................");
		System.out.println("....................................................");
		System.out.println("....................................................");
		System.out.println("....................................................");
		
		System.exit(0);
	}
	

	// final method can never be overriding
	final void doSomething() {
		// something
	}

}
