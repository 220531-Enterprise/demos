package com.revature.abstraction;

public class Tabby extends Cat{

	static final String gender = "FEMALE";
	
	// because CAT enforces a special constructor
	public Tabby(boolean hasFur) {
		super(hasFur);
		
	}

}
