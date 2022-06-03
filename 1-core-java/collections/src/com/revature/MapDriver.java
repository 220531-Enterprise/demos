package com.revature;

import java.util.HashMap;
import java.util.Map;

import com.revature.models.Animal;

public class MapDriver {
	
	/**
	 * Map is an interface that DOES NOT extend the iterable interface...but it is a collection of data
	 * 
	 * a Data Structure - considered par tof the Collection Framework (but not of collection hierarchy)
	 * 
	 * -- HashMap vs. TreeMap
	 * -- HashMaps allow storing at most 1 null key
	 * -- TreeMap doesn't allow a null key , but may allow a null value
	 */
	
	public static void main(String[] args) {
		
		// A Map is a set of key value pairs - 
		// no duplicate keys, but duplicate values
		// example: Kind = to be a good person to others. Nice = to be a good person to others
		
		// Dictionary of programming languages
		// define tkhe key and value types
		Map<String, String> languages = new HashMap<String, String>();
		
		// use put to insert data into the map
		languages.put("Java", "a high-level, OOP language that's platform indepoendent");
		languages.put("Python", "an interpreted OOP language");
		languages.put("JavaScript", "interpreted, multi-paradigm language that runs in a browser.");
		
		/**
		 * You may not have duplicate keys, but you can have duplicate values
		 */
		
		languages.put("JavaScript", "NOT Java"); // this will overwrite the preexisting key/value pair
		
		// retrieve a value?
		System.out.println(languages.get("Java")); // contant time retrieval O(1)
		
		// O(1) constant look-up time for Maps
		String someGarbage = (languages.get("Java") + "some words ....");
		
		Map<Integer, Animal> zoo = new HashMap<Integer, Animal>();
		
		// to iterate over all the keys in a Map
		for (String key : languages.keySet()) {
		
			System.out.println(key);
		}
		
		for (String definition : languages.values()) {
			
			System.out.println(definition);
		}
		
		// iterate over the entire entry of a Mpap
		for (Map.Entry<String, String> entry : languages.entrySet()) {
			System.out.println(languages);
		}
		
	}
	

}
