package com.revature.dao;

import java.util.List;

import com.revature.models.Account;

public interface IAccountDao {

	// 4 Main CRUD Methods for Account objects
	
	// Create:
	int insert(Account a); // return the primary key that's generated
	
	// Read:
	Account findById(int id);
	List<Account> findAll(); // returns a list of all accounts
	List<Account> findByOwnerId(int accOwnerId); // returns list of accounts that 
												 // belong to a User

	// Update: 
	boolean update(Account a); // return whether the update was successful or not
	
	// Delete
	boolean delete(int id); 
	
}
