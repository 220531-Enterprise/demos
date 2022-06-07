package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

/**
 * DAO Implementation Class
 * 
 * This class is part of the DAO design pattern and its responsibility is
 * for separating persistence logic from the rest of the application (separated
 * from the business layer a.k.a Service layer).
 */
public class UserDaoImpl implements IUserDao{

	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	@Override
	public int insert(User u) {
		
		// Step 1. Capture the connection to the DB by calling the ConnectionUtil's getConnection() method
		Connection conn = ConnectionUtil.getConnection(); // ctrl + shift + o
		
		// Step 2. Generate a SQL statmeent to insert the User into the Database
		String sql = "INSERT INTO users (username, pwd, user_role_name) VALUES (?, ?, ?) RETURNING users.id";
		// the RETURNING statement returns the value of the PK that's generated -- OWASP: SQL Injection
		
		
			
			// Step 3. Use a preapres statement to avoide SQL injection
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				// Step 4. set all of the ?? = to the value of the User's properties
				stmt.setString(1, u.getUsername());
				stmt.setString(2, u.getPwd());
				
				// This is a work around to transpose a Java ENUM to a RDBMS ENUM....
				stmt.setObject(3, u.getRole(), Types.OTHER);
				
				// Step 5. Iterate over the info that the DB returns
				ResultSet rs; // ResultSet is an interface from the JDBC API that allows us the behavior
							  // of an object to iterate over data received from a database
				
				if ((rs = stmt.executeQuery()) != null) {
					
					// if we return data, we iterate over it 
					rs.next();  // moves the cursor of the ResultSet over the information
					
					 // capture the PK and save it
					 int id = rs.getInt(1); // capture the value of the first column #1 (which is id) of the record that's returned.
					 
					 logger.info("Returned User with " + id);
					 
					 // if we're successful, return the ID
					 return id;
				}

			} catch (SQLException e) {
				logger.error("Unable to insert User - SQL exception thrown");
				e.printStackTrace();
			}

		return -1;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
