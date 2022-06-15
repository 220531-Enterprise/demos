package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Crime;
import com.revature.util.HibernateUtil;

public class CrimeDao {
	
	// CRUD methods
	
	// Create: return the PK that's generated in the DB
	public int insert(Crime crime) {
		
		// capture a session (call the getSession() method from the helper class
		Session ses = HibernateUtil.getSession();
		
		// set up a Transaction 
		Transaction tx = ses.beginTransaction(); // Transaction interface is uniquely from Hibernate
		
		// capture the value returned from calling .save() on the object
		int pk = (int) ses.save(crime);
		
		/**
		 * Objects in a Hiberate app in relation to the Session can be
		 * 
		 * - Transient (never in a relationship with the session - has never been persisted to the database)
		 * - Persistent (in a relationship with the session and has been persisted)
		 * - Detached (the session it was related to was closed - broken up with session) 
		 */
		
		// commit the transaction
		tx.commit();
		
		// return the PK
		return pk;
		
	}
	
	
	// Read
	
	// Update
	
	// Delete 

}
