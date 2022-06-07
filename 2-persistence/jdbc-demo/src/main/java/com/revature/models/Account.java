package com.revature.models;

/**
 * THis Account class will represent object that can be inserted into the accounts table
 *
 */
public class Account {
	
	private int id;
	private double balance;
	// this COULD be a User object but int makes more sense right now
	private int accOwner; // in the case of joint accounts inwhich one account is owned by many, this could be an Arraylist
	private boolean isActive; 
	
	public Account() {
		
	}

	/**
	 * To quickly create a class, right click and click Source >
	 * 
	 *  - Generate Constructors from Fields
	 *  - Generate Getters & Setters
	 *  - Generate hashCode & equals
	 *  - Generate toString()
	 */
	public Account(int id, double balance, int accOwner, boolean isActive) {
		super();
		this.id = id;
		this.balance = balance;
		this.accOwner = accOwner;
		this.isActive = isActive;
	}


	// What if we create an Account from the console?
	// We need this constructor in the case that we instantiate the Account in the Java Program.
	// Then we send it to the database which assigns a Primary Key. (Serial Primary Key)
	// When we return the object from the database, it will have its assigned ID
	public Account(double balance, int accOwner, boolean isActive) {
		super();
		this.balance = balance;
		this.accOwner = accOwner;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccOwner() {
		return accOwner;
	}

	public void setAccOwner(int accOwner) {
		this.accOwner = accOwner;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accOwner;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + (isActive ? 1231 : 1237);
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
		Account other = (Account) obj;
		if (accOwner != other.accOwner)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		if (isActive != other.isActive)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", accOwner=" + accOwner + ", isActive=" + isActive + "]";
	}
	
	
	
}
