package com.revature.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class App {

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
		
		/**
		 * A Lambda Expression is a short block of code which takes in 
		 * parameters and returns a value.
		 * 
		 * Lambda expressions are similar to methods but they don't have a name.
		 * and are useful for providing a quick implementation for functional interfaces.
		 */
		
		// I want to print out EACH employee object on 1 line
		
//		for (Employee e : employees) {
//			System.out.println(e);
//		}
		
		employees.forEach(e -> System.out.println(e));
		
		employees.forEach(e -> {
			// with curly brackets, I can add multiple lines to my method impl
			System.out.println(e.getName());
			System.out.println("has worked " + e.getYearsWorked() + " years.");
			System.out.println();
		});
		
		// forEach can simply use a lambda expression which provides the implementation of the accept() method
		// which comes from the Consumer Functional interface.
		
		// forEach can take in an instance of a class that has implemented the Consumer Interface
		// forEach can take in an anonymous class that implements the consumer interface
		
		System.out.println("=========== Instance of Class that implements interface ==================");
		employees.forEach(new PrintIt());
		
		System.out.println("========== ANON CLASS==============");
		
		employees.forEach(new Consumer<Employee>() {

			@Override
			public void accept(Employee e) {
				System.out.println(e);
				
			}
			
		});
		
		// This expression is standing in for the implementation of the accept() method
		// that comes from the Consumer Functional Interface
		employees.forEach(e -> System.out.println(e));
		
		
		/**
		 * Lambda Expressions
		 * FUnctional Interfaces 
		 * Anonymous Classes 
		 */
		
	}

}


class PrintIt implements Consumer {

	@Override
	public void accept(Object t) {
		System.out.println(t);
		
	}
}

