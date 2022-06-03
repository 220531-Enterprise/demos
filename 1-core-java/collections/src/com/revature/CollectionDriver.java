package com.revature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

import com.revature.models.Animal;

public class CollectionDriver {

	public static void main(String[] args) {
		
		/*
		 * List
		 * 
		 * A List is an ordered Collection (sometimes called a sequence). Lists may contain duplicate elements.
		 * In addition to the operations inherited from Collection, the List interface includes operations for the following:
		 * 
		 * 		+ Positional access 
		 * 			— manipulates elements based on their numerical position in the list. This includes 
		 * 			  methods such as get, set, add, addAll, and remove.
		 * 
		 * 		+ Search 
		 * 			— searches for a specified object in the list and returns its numerical position. 
		 * 			  Search methods include indexOf and lastIndexOf.
		 * 
		 * 		+ Iteration 
		 * 			— extends Iterator semantics to take advantage of the list's sequential nature. 
		 * 			  The listIterator methods provide this behavior.
		 * 
		 * 		+ Range-view 
		 * 			— The sublist method performs arbitrary range operations on the list.
		 * 
		 * The Java platform contains two general-purpose List implementations. LinkedList, which performs well when adding or removing from 
		 * the collection frequently. An ArrayList which offers better performance when the collection will be accessed frequently (get and 
		 * set methods).
		 * 
		 * ArrayList (one concrete implementation - implementation class)
		 * - retrieval - with O(1) with .get() method
		 * - Insertion/deletion - O(n)
		 * 
		 * LinkedList 
		 * - retrieval is O(n)
		 * - insertion/deletion is O(1)
		 */
		
		// create an arraylist to store number
		List<Integer> numbers = new ArrayList<Integer>(); // imported from java.util
		numbers.add(42);
		numbers.add(73);
		numbers.add(11); // Autoboxing is occuring transformint primitive into wrapper class
		
		
		System.out.println(numbers);
		System.out.println(numbers.get(1)); // O(1)
		
		// arraylists expand 50% if you're adding more elements thatn there is space for
 
		numbers = new LinkedList<Integer>(); // O(n) -- operations is linear to the amount of elemetns in the data set
		
		List<Animal> animalList = new LinkedList<>();
		
		Animal tiger1  = new Animal("tiger", "orange");
		Animal tiger2 = new Animal("tiger", "orange");
		Animal tiger3 = new Animal("tiger", "white");
		
		
		animalList.add(tiger1);
		animalList.add(tiger2);
		animalList.add(tiger3);
		
		// print out each animal in the collection on a new line
		
		// enhanced for loop
		for (Animal a : animalList) {
			System.out.println(a);
		}
		
		/*
		 * Vector differs from ArrayList in 2 ways:
		 * 
		 * - Data Growth: A vector will double in size when it expands. (Whereas an ArrayList increases by 50%) 
		 * 
		 * - Synchronization: It's slower because it blocks multiple threads from using it at once. (locking).
		 * 		- If you're dealing with a multi-threaded program, and multiple threads are accessing one List,
		 * 		- you want to make sure it's a Vector.
		 */
		
		List<String> words = new Vector<>(); // same time complexity as an array list
		words.add("Hello");
		words.add("world");
		words.remove(0);
		System.out.println(words.get(0));
		
		/*
		 * Set
		 * 
		 * A Set is a Collection that cannot contain duplicate elements. It models the mathematical set abstraction. The Set 
		 * interface contains only methods inherited from Collection and adds the restriction that duplicate elements are 
		 * prohibited. 
		 * 
		 * Set also adds a stronger contract on the behavior of the equals and hashCode operations, allowing Set 
		 * instances to be compared meaningfully even if their implementation types differ. Two Set instances are equal if they 
		 * contain the same elements.
		 * 
		 * Unlike List and arrays, Set does NOT support indexes or positions of it's elements. Use an iterators to iterate over it.
		 */
		
		System.out.println("================== SETS BELOW ==================");
		
		Set<Animal> animalSet = new HashSet<>();
		
		animalSet.add(tiger1);
		animalSet.add(tiger2);
		animalSet.add(tiger3);
		animalSet.add(new Animal("wolf", "grey"));
		
		// enhanced for loop - we don't need the index
		for (Animal a : animalSet) {
			System.out.println(a); // add some getters & setters to the Animal class
		}
		
		// how do we retrieve from a Set?
		// because Set extends the COllection INterface which extends ITERABLE interaface
		for (Iterator<Animal> it = animalSet.iterator(); it.hasNext(); ) {
			// find the grey wolf!!!!
			
			Animal a = it.next();
			//check is the animal at the iterarotor is equal to the grey wolf
			if (a.getColor().equals("grey") && a.getSpecies().equals("wolf")) {
				System.out.println("Found the grey wolf");
			}
			
		}
		
		/**
		 * Queue Interface
		 * 
		 * FIFO - first in, first out
		 * allows for extra operations
		 */
		System.out.println("===============QUEUES===============");
		
		// Inferring Generics by passing the Wrapper class of the type of object that I'm going to collect
		Queue<Animal> animalQ = new LinkedList<Animal>();
		animalQ.add(tiger1);
		animalQ.add(tiger2);
		animalQ.add(tiger3);
		
		// build a while loop, WHILE the q is NOT empty,remove the HEAD of the queue
		while (animalQ.size() != 0) {
			
			System.out.println("Queue Size " + animalQ.size());
			
			// call the poll() method to remove the head of the queue and print it out
			System.out.println("Processing.... " + animalQ.poll());
			
			
		}
		
		
		
		
		
	}
	
	
	

}
