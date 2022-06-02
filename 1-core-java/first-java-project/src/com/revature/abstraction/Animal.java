package com.revature.abstraction;

// You CANNOT instantiate an Abstract class!!
public abstract class Animal {

	private int legs;
	private String color;
	
	public Animal() {
		System.out.println("The animal constructor has been called");
	}
	
	// it means I defined the signature, and that it must be inherited for the child class to 
	// customize the implementation
	public abstract void makeSound();
	
	// you can have CONCRETE methods
	public void exist() {
		System.out.println("I EXIST!!!!!!");
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
