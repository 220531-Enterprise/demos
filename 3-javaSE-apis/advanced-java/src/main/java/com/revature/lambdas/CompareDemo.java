package com.revature.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class CompareDemo {

	public static void main(String[] args) {
		
		Employee abby = new Employee("Abby Adams", 40, 13.2);
		Employee bob = new Employee("Bob Briggs", 22, 2.5);
		Employee carter = new Employee("Carter Cobb", 20, 1);
		Employee doug = new Employee("Doug Doberman", 52, 32);
		Employee emily = new Employee("Emily Evanson", 34, 4.2);

		List<Employee> employees = new ArrayList<>();
		
		employees.add(emily);
		employees.add(carter);
		employees.add(abby);
		employees.add(doug);
		employees.add(bob);
		
		employees.forEach(e -> System.out.println(e));
		//employees.forEach(System.out::println); // Method Referencing -- produces the same output
		
		// How do I sort this list of employees?
		Collections.sort(employees);
		
		System.out.println("+====== sorted =====");
		employees.forEach(System.out::println);
		
		List<Integer> nums = new ArrayList<>();
		
		nums.add(423);
		nums.add(21);
		nums.add(9);
		
		Collections.sort(nums);
		nums.forEach(n -> System.out.println(n));
		
		
		// Comparable needs to be implemented by the class itself and override the compareTo() method
		// Comparator interface has the compare() method which can be implemented by an separate class
			// OR have the compare method provided for by a lambda expression or anonymous class
		
		
		// (1) Pass thru an instance of a Class that implements Comparator - sort by Name
		Collections.sort(employees, new NameSorter());
		
		// (2) implement the compare() method by use of anonymous class
		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				// TODO Auto-generated method stub
				return e1.getName().compareTo(e2.getName());
			}
			
		});
	
		// (3) Lambda Expression -- a much more succinct way of doing the above
		Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
		
		Consumer<Employee> myFunction =  e -> System.out.println(e);
		// wherever a consumer function is accepted, you can pass this method
		employees.forEach(myFunction);
		
		
		/**
		 * Challenge: Create an AGE Sorter via the Comparator interface via 3 ways:
		 * 
		 * (1) Create a class called AgeSorter that implements Comparator 
		 * (2) Use Anon Class to call Collections.sort(employees, new Comparator<Employee>() { ...... }
		 * (3) Create a lambda expression that sorts employees by age
		 * 
		 * Answer at 12:45pm ET
		 */
		
		// ANSWER #1  sorting the employees data structure by the comparator class
		Collections.sort(employees, new AgeSorter());
		
		// ANSWER #2 using Anonymous class
		Collections.sort(employees, new /* ghost class */ Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getAge() - e2.getAge();
			}
		});
		
		// ANSWER #3 using lambda expression
		Collections.sort(employees, (e1, e2) -> e1.getAge() - e2.getAge());

	}

}

class AgeSorter implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
	
		return e1.getAge() - e2.getAge();
	}
	
	
	
}


class NameSorter implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		// I'm piggy backing off of the String class's compareTo() method
		return e1.getName().compareTo(e2.getName());
	}

}

