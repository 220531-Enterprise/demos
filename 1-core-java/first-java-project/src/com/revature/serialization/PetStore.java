package com.revature.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PetStore {
	
	// collection of PETS
	private ArrayList<Pet> petDB = new ArrayList<Pet>(); 
	
	// ArrayList is a class Implementation of the List interface
	// ArrayList is like an  array that can expand and shrink when we need it to (think dynamic array)
	// great for retrieval O(1) constant time complexity for retrieval 
	
	/**
	 * When I invoke the serialize method on a pet Store object it will serialize
	 * the ArrayList of Pet objects to a file
	 * 
	 * It will transform them to a bit stream and write it to a file.
	 * 
	 * This stream of bits can rehydrated (deserialization) at a later point in
	 * time by reading from the file.
	 */
	public void serialize() throws FileNotFoundException, IOException{
		
		// java.io is input output package 
		// Here the compiler senses a CHECKED exception and forces us to handle it
		try {
			// (1)
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/pet.db"));
			
			// (2)
			oos.writeObject(this.getPetDB());
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	// deserialize method() 
	

	public ArrayList<Pet> getPetDB() {
		return petDB;
	}

	public void setPetDB(ArrayList<Pet> petDB) {
		this.petDB = petDB;
	}

	@Override
	public String toString() {
		return "PetStore [petDB=" + petDB + "]";
	}
	
	
	
}
