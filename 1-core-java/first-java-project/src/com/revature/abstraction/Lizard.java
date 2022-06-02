package com.revature.abstraction;

public class Lizard extends Animal implements Ectothermic{

	@Override
	public void makeSound() {
		System.out.println("scratch scratch");
		
	}

	@Override
	public void heatUp() {
		System.out.println("I'm basking on a rock to get blood temp up");
		
	}

	@Override
	public void coolDown() {
		// TODO Auto-generated method stub
		
	}

}
