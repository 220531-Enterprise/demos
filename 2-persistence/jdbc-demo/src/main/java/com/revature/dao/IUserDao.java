package com.revature.dao;

import java.util.List;

import com.revature.models.User;

/**
 * DAO Interface (Specific to the User object it performs CRUD ops on)
 * 
 * The DAO or (Data Access Object) consists of a DAO interface which 
 * outlines the CRUD methods to be performed on a particular object
 *
 * The DAO Implementation Class will take on the responsibility of providing
 * the actual implementation for each method.
 * 
 * The pupose of the DAO design pattern is to separate business logic from persistence logic
 */
public interface IUserDao {

	// Create
	int insert(User u); // return's the User object's newly formed primary key as an int
	
	// Read
	User findById(int id); // return User object based on a SQL statement to query for it by ID
	User findByUsername(String username); // return User object based on username you pass through
	List<User> findAll(); // SELECT * FROM users;
	
	// Update
	boolean update(User u); // return true or false based on whether we updated the row (success or not)
	
	// Delete
	boolean delete(int id); // return whether the delete was successful or not
		
	
}
