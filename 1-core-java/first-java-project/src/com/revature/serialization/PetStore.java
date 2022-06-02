package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

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
		
		// try with resources automatically closes the resources you're trying to invoke some methods on
			// (1)
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/pet.db"))) {
			
			// (2)
			oos.writeObject(this.getPetDB());
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		
	}
	
	// deserialize method() 
	// read from a file and set the petStore object's Database equal to the objects stored in a file
	@SuppressWarnings("unchecked")
	public void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
			
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/pet.db"));
				
				// set the petDB arraylist EQUAL TO the value of whatever this ois reads from the file 
				this.setPetDB((ArrayList<Pet>) ois.readObject());
		}

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
