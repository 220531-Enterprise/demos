package com.revature.abstraction;

/**
 * Why And When To Use Interfaces?
 * 
 * 1) To achieve security - hide certain details and only show the important
 * details of an object (interface).
 * 
 * 2) Java does not support "multiple inheritance" (a class can only inherit
 * from one superclass). However, it can be achieved with interfaces, because
 * the class can implement multiple interfaces. Note: To implement multiple
 * interfaces, separate them with a comma.
 **/
public interface Ectothermic {
	
	// we use STATES in interfaces to declare CONSTANTS
	
	// by default these fields are public static final
	public static final int MIN_BODY_TEMP = -40;
	
	// also public static final (I just don't neede to write it) 
	int MAX_BODY_TEMP = 90;
	
	// all methods of an interface are BY DEFAULT public abstract
	public abstract void heatUp(); // just declare the signature of the method, not the implementation
	
	// all you really need to do is write the return type and name of the method, becuase
	// by default it's public and abstract
	void coolDown();
	
	// Since Java 8 default methods were introduced (which are methods with a impleentation)
	default void doSomething() {
		System.out.println("I'm doing somethign!!!");
	}
	
	// any class that implements this interface will
	// have to inherit th default methods AS THEY ARE

}
