package com.revature.lambdas;

// A simple POJO (Plain Old Java Object)
public class Employee implements Comparable<Employee>{

	private String name;
	private int age;
	private double yearsWorked;

	public Employee(String name, int age, double yearsWorked) {
		super();
		this.name = name;
		this.age = age;
		this.yearsWorked = yearsWorked;
	}
	
	// This method comes from the functional interface Comparable
	@Override
	public int compareTo(Employee e) {
		// we want to compare employees by the time they've worked
		// Call Doubl Wrapper class 
		return (int) (this.getYearsWorked() - e.getYearsWorked());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getYearsWorked() {
		return yearsWorked;
	}

	public void setYearsWorked(double yearsWorked) {
		this.yearsWorked = yearsWorked;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", yearsWorked=" + yearsWorked + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(yearsWorked);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(yearsWorked) != Double.doubleToLongBits(other.yearsWorked))
			return false;
		return true;
	}

}
