package com.revature.abstraction;

public class Cat extends Animal{

	boolean hasFur;


	public Cat(boolean hasFur) {
		super(); // invokes the parent constructor
		this.hasFur = hasFur;
	}


	@Override
	public void makeSound() {
		System.out.println("MEOW!!!!");
		
	}

}
