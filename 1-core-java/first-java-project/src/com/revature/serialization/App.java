package com.revature.serialization;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		// instantiate some Pet objects! Objects go to the heap!
		Pet p1 = new Pet("Fluffy", 1004, "Cat", "Larry", 4, Color.GREY);
		Pet p2 = new Pet("Spot", 2234, "Dog", "Marry", 2, Color.BROWN);
		
		// We need a petStore!
		PetStore petco = new PetStore();
		
		// grabbing the arraylist of pets that belongs to petco
		ArrayList<Pet> petcoDb = petco.getPetDB();
		
		// add p1 and p2 to poetco's arraylist database
		petcoDb.add(p1);
		petcoDb.add(p2);
		
		
		// serialize petco's store! -- wrting the entire contents of the collection to a file
		try {
			petco.serialize();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		// because we declared that this method throws checked exceptions
		

	}


}
