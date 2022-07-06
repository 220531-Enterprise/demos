package com.revature.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.UserRepository;
import com.revature.models.User;
import com.revature.models.UserRole;

@Service // STEREOTYPE annotation which specifies the duties of this component
public class UserService {
	
	private UserRepository userRepository;
	
	// Constructor Based DI
	// Spring Data will generate an implemention class UserRepositoryImpl Bean automatically
	// and inject it into an instance of UserService everytime UserService is called.
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	/**
	 * @Transactional on Service methods:
	 * 				  In the case that multiple dao methods were
	 *                being called, we want to make sure that those methods are
	 *                fired against the DB in one unit of work (transaction).
	 */
	// Register a User to the DB
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User processRegister(User newUser) {
		newUser.setRole(UserRole.BASIC_USER);
		newUser.setRegisterDateTime(LocalDateTime.now());
		return userRepository.save(newUser);
	}
	
	// Imagine that the Frontend app sends an object that has 2 properties 
	// username and password - Data Transfer Object
	// pass a credentials object
	public User processLogin(String username, String password) {
		// call a repo method that reutrns a user based on password and username
		return userRepository.findUserByUsernameAndPassword(username, password);
	}
	
	// Get all Useres from the DB
	@Transactional(readOnly=true)
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Optional<User> getById(int id) {
		return userRepository.findById(id);
	}
	
	public User updateUser(User updatedUser) {
		return userRepository.save(updatedUser); // replaces the old record
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

}







