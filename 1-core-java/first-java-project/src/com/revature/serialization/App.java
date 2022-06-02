package com.revature.serialization;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
//		// instantiate some Pet objects! Objects go to the heap!
//		Pet p1 = new Pet("Fluffy", 1004, "Cat", "Larry", 4, Color.GREY);
//		Pet p2 = new Pet("Spot", 2234, "Dog", "Marry", 2, Color.BROWN);
//		
//		// We need a petStore!
//		PetStore petco = new PetStore();
//		
//		// grabbing the arraylist of pets that belongs to petco
//		ArrayList<Pet> petcoDb = petco.getPetDB();
//		
//		// add p1 and p2 to poetco's arraylist database
//		petcoDb.add(p1);
//		petcoDb.add(p2);
//		
//		// A checked exception is an exception that your COMPILER will "check" and FORCE you to handle
//		
//		// An unchecked exception (typically runtime exceptions) is something that is
//		// not known at the time of development/compilation - it occurs at runtime, there's no way for the compiler
//		// to predict it or force you to handle it
//		
//		// serialize petco's store! -- wrting the entire contents of the collection to a file
//		try {
//			petco.serialize();
//		} catch (FileNotFoundException e) {
//		
//			e.printStackTrace();
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		} 
		
		// because we declared that this method throws checked exceptions
		
		
		// build a new pet store
		PetStore petSmart = new PetStore();
		
		// this new pet store is going to READ FROM A FILE and make it's Database eqaul to all of the pets that
		// are stored in this file
		try {
			petSmart.deserialize(); // read all the data inside the file
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		// l;et's see if the databse of the petSmart was set equal to what it read from the filej
		System.out.println(petSmart.getPetDB());
	}


}
