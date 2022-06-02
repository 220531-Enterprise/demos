package com.revature.abstraction;

public class App {

	public static void main(String[] args) {
		
		// Liskov Substitution Pricipal
		Animal a1 = new Cat(true);
		// the Cat Object inherits the super constructor from its parent
		
		a1 = new Frog();
		
		a1.exist();
		a1.makeSound();
		
		
		// BECAUSE ANIMAL is an ABSTRACT CLASS, you lose
		// all the sepcifics of the child classes and their interfaces
		
		Frog kermit = new Frog();
		
		kermit.doSomething(); // default method from Ectothermic
		kermit.swim();
		
		
	}

}
