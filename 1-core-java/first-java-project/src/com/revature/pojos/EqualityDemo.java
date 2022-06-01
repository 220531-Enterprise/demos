package com.revature.pojos;

public class EqualityDemo {

	public static void main(String[] args) {

		// instantiate 2 people objects with the same value
		Person p1 = new Artist("Timmy", 42);
		Person p2 = new Artist("Timmy", 42);

		// we KNOW that these 2 objects will have different memory addresses in the heap
		
		System.out.println("Does p1 have the same value as p2? " + p1.equals(p2));
		System.out.println("Does p1 share the same address in memory as p2? " + (p1 == p2));

		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}

}
