package com.revature.abstraction;

public class Frog extends Animal implements Amphibious, Ectothermic{

	@Override
	public void makeSound() {
		System.out.println("ribbit ribbit");
		
	}

	@Override
	public void heatUp() {
		System.out.println("Ribbit ribbit I'm raising blood temp ");
		
	}

	@Override
	public void coolDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swim() {
		System.out.println("I'm a frog, I can swim!!!");
		
	}
	

}
