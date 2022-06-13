package com.revature;

import java.util.HashMap;
import java.util.Map;

/**
 * Location will be a fully immutable
 * class so that third-party plugins cannot 
 * modify the location instances of the game.
 *
 * When we create an immutable class we prevent the
 * properties/behavior of the instances from every being changed.
 */
public final class Location { // final prevents a class from being extended
	
	private final int locationId;
	private final String description;
	private final Map<String, Integer> exits; // {S, 4}
	
	public Location(int locationId, String description, Map<String, Integer> exits) {
		
		this.locationId = locationId;
		this.description = description;
		
		// if the exits is NOT null, we'll set the exits of the object
		// equal to an new HashMap with the same values of the exits passed thru
		if (exits != null) {
			
			this.exits = new HashMap<String, Integer>(exits); 
			// make a duplicate HashMap with the same values
			// as the map passed through
			
		} else {
			
			// in the case that the map (exits) passed thru is null, ....
			// create a new empty HashMap
			this.exits = new HashMap<String, Integer>();
		}
		
		// ALL locations offer the exit Q which will lead them to room 0
		this.exits.put("Q", 0); // ALL locations will have this exits record
	}
	
	public Map<String, Integer> getExits() {
		
		// we do NOT want to return this.exits
		// because if we did we open up the possibility for the calling progrma to MODIFY the location
		
		return new HashMap<String, Integer>(this.exits);
		// this returns a COPY (like a snapshot) that the calling program can't change 
	}

	// just open the option to get description and ID
	public int getLocationId() {
		return locationId;
	}

	public String getDescription() {
		return description;
	}
	
	

}
