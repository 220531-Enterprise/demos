package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Crime;
import com.revature.util.HibernateUtil;

public class CrimeDao {
	
	// CRUD methods
	
	// Create: return the PK that's generates in the DB
	public int insert(Crime crime) {
		
		// capture the session -- call getSession() from the HIbernate helper class
		Session ses = HibernateUtil.getSession();
		
		// set up a transaction (1 unit of work performed against the DB) 
		Transaction tx = ses.beginTransaction();
		
		// call the save() method from the session an reutnr the PK
		int pk = (int) ses.save(crime);
		
		// Session Methods exist for every type of operation
		
		// commit the tx
		tx.commit();
		
		// return the PK
		return pk;
		
	}
	
	
	// Read
	
	// Update
	
	// Delete 

}
