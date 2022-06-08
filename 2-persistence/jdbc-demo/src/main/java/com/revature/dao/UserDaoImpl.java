package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.models.Role;
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
			
			// Step 3. Use a prepared statement to avoid SQL injection
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				// Step 4. set all of the ?? = to the value of the User's properties
				stmt.setString(1, u.getUsername()); // the 1 refers to the order of the ?'s in the prepared statement
				stmt.setString(2, u.getPwd()); // Here we'e setting the second ? mark (hence the 2)
				
				// This is a work around to transpose a Java ENUM to a RDBMS ENUM....
				stmt.setObject(3, u.getRole(), Types.OTHER);
				
				// Step 5. Iterate over the info that the DB returns
				ResultSet rs; // ResultSet is an interface from the JDBC API that allows us the behavior
							  // of an object to iterate over data received from a database
				
				if ((rs = stmt.executeQuery()) != null) {  // rs = stmt.executeQuery will generate a record of data to iterate over
					
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
		
		// 1. Establish a temp User object which will be returned 
		User u = new User(); // by default the user's id is going to be 0
		
		// 2. Call on the Connection from our ConnectioUrtil class
		try (Connection conn = ConnectionUtil.getConnection()) { // try with resources closes the resource after we open it
			
			// 3. Write a SQL statement to return the User with the username you're passing through
			String sql = "SELECT * FROM users WHERE username = ?"; // JDBC API is built into the JRE java.sql
			
			// 4. Use a Prepared Statement to Prevent SQL Injection
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// 5. Set the value of the ? equal to the username that's passed in
			stmt.setString(1, username); // replace the first question mark with the value of the username that's passed through
			
			// 6. Declare a ResultSet object
			ResultSet rs; // whatever object this ref variable points to has the behavior of a result 
			
			// 7. execute the query and IF it's not null, iterate over the data that's returned
			if ((rs = stmt.executeQuery()) != null) { 
				
				// we iterate over the data returned byu using rs.next()
				if (rs.next() == true) {
					
					// 8. capture the id of the User
					int id = rs.getInt("id"); // returns the value of the user objects ID in the id column
					String returnedUsername = rs.getString("username");
					String password = rs.getString("pwd");
					
					// to get the ENUM from the DB and transform it into a Java Enum
					Role role = Role.valueOf(rs.getString("user_role_name")); // object transpostion (transforming a DB type into a java type)
					
					// 9. Set all the properties of our Temp user to what we returned from the DB
					u.setId(id);
					u.setUsername(returnedUsername);
					u.setPwd(password);			
					u.setRole(role);
				}
				
			}	else {
				logger.info("The User with the username " + username + " does not exist");
//				return u; technically redundant, just ending the method early
			}
			
		} catch (SQLException e) {
			logger.warn("SQL Exception thrown  -- can't retrieve User from DB");
			e.printStackTrace();
		}
		
		return u; // return the successfully intialized User IF the suer comes from the DB, it will have an ID > 0
				  // If we were unsuccessful, the id is by default 0
	}

	@Override
	public List<User> findAll() { // id, username, pwd, role, account id, account balance, isActive
	// we can't to call upon both the user data and their account data to fulgill a list of users with coplete lists of accoutns
		
		// make an empty list to store all the users (maybe a set)
		List<User> allUsers = new LinkedList<User>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			Statement stmt = conn.createStatement(); // from the view I created
			
			String sql = "SELECT * FROM users_account_data";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				
				// grab the id, username, password, role
				int userId = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("pwd");
				Role role = Role.valueOf(rs.getString("user_role_name"));
				
				// we have enough data to construct a User object, onto the Account object 
				
				// the value of the int wil be 0 if it's null
				int accId = rs.getInt("account_id"); // this refers to the alias we provided in the view
				double balance = rs.getDouble("balance");
				boolean isActive = rs.getBoolean("active");
				
				
				// if the account id is 0 
				if (accId == 0) {
					// instantiate the User with empty list of accounts
					User u = new User(userId, username, password, role, new LinkedList<>());
					allUsers.add(u);
				} else {
					
					Account a = new Account(accId, balance, userId, isActive);
					
					// we need some way to check if the user  already exists in our list, and
					// add appropraoate
				
					// TODO: FGINISH THIS METHOD
				}
				
				
			}	
			
		} catch (SQLException e) {
			logger.warn("SQL Exception throwns, can't retreive all users from the DB);
			e.printStackTrace();
		}
		
		
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
