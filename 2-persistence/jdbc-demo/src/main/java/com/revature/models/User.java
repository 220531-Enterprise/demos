package com.revature.models;

import java.io.Serializable;
import java.util.List;

/**
 * This User model will have SIMILAR properties to our User table
 * 
 * We'll make this a Java Bean design pattern
 * 
 * 1. All properties must be private and use getters and setters
 * 2. A public no-args constructor must be available
 * 3. Implements the Serializable interface  
 */
public class User implements Serializable{
	
	private int id;
	private String username;
	private String pwd;
	private Role role; // this will correlate to the ENUM type
	
	private List<Account> accounts;

	// no args constructor 
	public User() {
		
		
	}

	// full parameterized constructor
	public User(int id, String username, String pwd, Role role, List<Account> accounts) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.role = role;
		this.accounts = accounts;
	}

	// one constructor WITHOUT ID because the DB is creating the primary key which is the ID
	public User(String username, String pwd, Role role, List<Account> accounts) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.role = role;
		this.accounts = accounts;
	}
	
	// add this method
	public boolean addAccount(Account a) {
		
		return this.accounts.add(a);
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ", role=" + role + ", accounts="
				+ accounts + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (role != other.role)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}














