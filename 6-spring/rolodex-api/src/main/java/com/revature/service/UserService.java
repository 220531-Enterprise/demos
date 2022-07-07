package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.AddressRepository;
import com.revature.data.UserRepository;
import com.revature.dto.Credentials;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

@Service
public class UserService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private UserRepository userRepo;
	private AddressRepository addressRepo;
	
	@Autowired
	public UserService(UserRepository userRepo, AddressRepository addressRepo) {
		super();
		this.userRepo = userRepo;
		this.addressRepo = addressRepo;
	}
	
	// the CONTROLLER will pass the creds obj to the Service
	public User authenticate(Credentials creds) {
		
		User userInDb = userRepo.findUserByUsernameAndPassword(creds.getUsername(), creds.getPassword())
				.orElseThrow(AuthenticationException::new);
		
		return userInDb;
		
	}
	@Transactional(readOnly=true)
	public Set<User> findAll() {
		// here we are using the stream API to transform the List to a Set to avoid duplicate
		return userRepo.findAll().stream().collect(Collectors.toSet());
	}
	
	// Every time that this method is invoked, we want to begin a new Transaction (unit of work against the DB)
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User add(User u) {
		
		// check if the user object being added owns any addressed (u.getAddresses != null)
		if (u.getAddresses() != null) {
			u.getAddresses().forEach(address -> addressRepo.save(address));
		}
			// if it isn't null, iterate over them and add each Address object
		return userRepo.save(u);
	}
	
	@Transactional(propagation=Propagation.REQUIRED) // default setting of transactions in Spring
	public void remove(int id) {
		
		userRepo.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public User getByUsername(String username) {
		
		// set up custom exception handling in the case that this optional returns a null user
		return userRepo.findByUsername(username) // in the case that no User object can be returned, throw an exception
				.orElseThrow(() -> new UserNotFoundException("No user found with username " + username));
	}
	
	@Transactional(readOnly=true)
	public User getById(int id) {
		
		if (id <= 0) {
			log.warn("Id cannot be <= 0. Id passed was: {}", id);
			return null;
		} else {
			return userRepo.findById(id)
					.orElseThrow(() -> new UserNotFoundException("No user found with id " + id));
		}
		
	}
}