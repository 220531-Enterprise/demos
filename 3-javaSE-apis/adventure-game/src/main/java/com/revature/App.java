package com.revature;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

	private static Scanner scan = new Scanner(System.in);
	
	// establish all locations as a Map that belongs to the App class
	// allow us to associate a locationId with a Location object
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	
	public static void main(String[] args) {
		
		// BEFORE we start prompting the user to go somewhere
		// we need to instantiate all of our locations that exist on the map

		// The first location we create is homebase
		Location homeBase = new Location(0, "You're sitting at the computer learning Java", null); 
		locations.put(0, homeBase);
		
		/**
		 * Steps for making a Location
		 * 1. Create a HashMap that holds all its exits
		 * 2. Instantiate the Location, passing the exits map as its extis param
		 * 3. put the new location object in the locations map 
		 */
		Map<String, Integer> tempExits = new HashMap<String, Integer>();
		// this map will be passed to the contructor of the Road Location object
		tempExits.put("N", 5);
		tempExits.put("E", 3);
		tempExits.put("S", 4);
		tempExits.put("W", 2);
		
		// 2.
		Location road = new Location(1, "You're standing at the end of a road leading to a brick building", tempExits);
		
		// 3.
		locations.put(1, road);
		
		// re-use tempExits by setting it to a new HashMap
		tempExits = new HashMap<String, Integer>();
		tempExits.put("N", 5);
		
		Location hill = new Location(2, "You're ontop of a grassy hill with a dark forest to the north", tempExits);
		
		locations.put(2, hill);
		
		// Put in the Building, Valley, and Forest locations
	}

}
