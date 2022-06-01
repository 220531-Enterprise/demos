package com.revature.pojos;

import java.io.Serializable;

/**
 * Employee is a Java Bean
 * 
 * -- all instance variables are private
 * -- it is serializable
 * -- it has override hashCode and equals() methods
 * -- getters & setters
 */
public class Employee extends Person implements Serializable{
	 
	  // this id defines the class that the serialized object comes from
	private static final long serialVersionUID = -6645485878431697253L;
	// serializable allows it to be compressed into a bit stream

	private String dept;
	
	
	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
	}


	// Hashcode is a numeric representation of the properties of an object
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Employee [dept=" + dept + "]";
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}

	// getters, setters, toString, hashCode and equals();
	

}
