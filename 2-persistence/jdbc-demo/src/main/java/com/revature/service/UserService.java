package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.IUserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.User;

/**
 * The Service Layer is repsonsible for processing data in our application
 * and calling upon the DAO layer to persist it (or query) 
 */
public class UserService {
	
	// this is a lowercase L
	private static Logger logger = Logger.getLogger(UserService.class);
	
	// DEPENDENCY INJECTION
	// Inject an instance of the DAO into this 
	private IUserDao udao; // declare that the Service owns a DAO object 
	
	// we need a way of injecting the implementation class of the DAO into this service object
	// CONSTRUCTOR INJECTION ensures that an instance of the UserService can never be created or used without having 
	// its dependencies fullfilled
	public UserService(UserDaoImpl udaoImpl) {
		
		this.udao = udaoImpl;
		
	}

	
	// register method returns the User after it has been processed and entered in the DB
	// and the User returned has an ID
	public User register(User u) {
		
		// check that the User DOESN'T already exist in the database
		// what method would be call from the DAO? maybe findByUsername()?
		
		String username = u.getUsername();
		
		User possibleUser = udao.findByUsername(username);
		
		// check the ID of the User returned nad if it's 0,  it doesn't exists, and if it's >0,. 
		// it does exists in teh DB
		if (possibleUser.getId() == 0) {
			
			// indicate successful registration and insert into the DB
			logger.info("successful registration of User with username " + username);
			int id = udao.insert(u); // the dao's insert method returns the PK that's generated
			
			u.setId(id);
			return u; // return the User after its ID has been assigned
			
		} else {
			// wherever we call this method, we need to try catch it to handle the instance of this exception
			throw new RegisterUserFailedException("Failed to register User because id was not 0 and the user already exists");
			
		}
	}
	
	// you can change the return type to whatever makes sense in your project
	public User login(String username, String password) {
		
		// first fetch the object by calling the findByUsername() method
		User returnedUser =  udao.findByUsername(username);
		
		// TODO:  add a check  incase returnedUser is Null
		
		// then check if the User object's password is EQUAL TO the password passed through here
		if (returnedUser.getPwd().equals(password)) { // provide some checks 
			
			logger.info("Successfully Logged in the user with username " + username);
			// if it is a match, return the user object
			
			return returnedUser; // return what you got from the DB
		}
		
		// if if it isn't return  null, and log some info
		logger.warn("password and username combo for user with username " + username + " was incorrect");
		
		return null;
		
	}
	
	public List<User> getAll() {
		
		return udao.findAll();
		
	}
	
	

}


















