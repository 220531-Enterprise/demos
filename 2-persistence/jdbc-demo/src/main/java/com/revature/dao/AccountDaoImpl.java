package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements IAccountDao{
	
	private static Logger logger = Logger.getLogger(AccountDaoImpl.class);

	@Override
	public int insert(Account a) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// SQL Statement (insert statement) 
			String sql = "INSERT INTO accounts (balance, acc_owner, active) VALUES (?, ?, ?) RETURNING accounts.id";
			
			// initialize the preparedstatment
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// set the question marks equal to the values of the Account object's properties
			stmt.setDouble(1, a.getBalance()); // the 1 is the FIRST question mark that we're replacing in the prepped statement
			stmt.setInt(2,  a.getAccOwner());
			stmt.setBoolean(3, a.isActive());
			
			// declare the Result set
			ResultSet rs;
			
			// check that the result set isn't null and indeed has an int to be returned
			if ((rs = stmt.executeQuery()) != null) {
				
				rs.next(); // pushes the cursor forward
				int id = rs.getInt("id");
				return id; // if the persistence of the Account object is successful			
			}
			
		} catch (SQLException e) {
			logger.warn("Unable to persist Account object to the DB");
			e.printStackTrace();
		}
		
		return -1; // returning -1 indicates that something went wrong in the insertion of an Account object
	}

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findByOwnerId(int accOwnerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
