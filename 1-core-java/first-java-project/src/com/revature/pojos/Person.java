package com.revature.pojos;

/**
 * A POJO stands for Plain Old Java Object 
 * Meaning...there are no naming conventions or 
 * access modifier restrictions to the proerties and methods of the class
 * (State & behavior)
 */
public abstract class Person { // ALL USER-DEFINED OBJECTS EXTEND FROM THE OBJECT CLASS
	
	public static int MAX_AGE = 115; // globally avialable at the class level (static)
	
	private String name;
	private int age;
	
	// if You do NOT define a constructor the JVM automatically
	// creates a DEFAULT COnstrcutor (a no-args constructor)
	
//	public Person() {
//		// no-args constructor
//	}
	
	// Fully parameterized contrcutor
	public Person(String name, int age) {
		
		// this refers to instance variables of the object that's being created
		this.name = name;
		this.age = age;
		
	}
	
	// this is an an INSTANCE level method, meaning I can only call it on an instance of the person class
	// void is a NON-return type - method doensn't return anything
	void introduceSelf() {
		System.out.println("Hello! I am " + this.name + ". I am " + this.age + " years old." );
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

	/**
	 * POLYMORPHISM - Overriding - keep the method signature, change the implementation
	 * 				- Overloading - keep the method signature, change the arguments (number or type of arguments) & implementation
	 */
	@Override // overriden from the Object class
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	// alt + shift + s OR right click go to SOURCE
	
	

}
