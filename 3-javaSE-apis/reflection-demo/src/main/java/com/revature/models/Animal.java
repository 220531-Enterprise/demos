package com.revature.models;

public class Animal {
	
	private String name;
	private int age;
	private String color;
	public String zoo;
	int numOfLegs; // default field
	
	
	public Animal(String name, int age, String color, String zoo, int numOfLegs) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
		this.zoo = zoo;
		this.numOfLegs = numOfLegs;
	}
	
	

}
