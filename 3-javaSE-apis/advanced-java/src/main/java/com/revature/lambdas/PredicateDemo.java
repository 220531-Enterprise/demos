package com.revature.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

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

		// Predicate functional interface: 3 different ways to provide an implementation
		// for the test() method
		// Check for employees over age 35
		
		// #1 Instance of Class that implements Predicate interface
		printEmployees35OrOlder(employees, new EmployeeAgeChecker());

		// #2 Anonymous Class 
		printEmployees35OrOlder(employees, new Predicate<Employee>() {

			@Override
			public boolean test(Employee e) {
				return e.getAge() >= 35 ? true : false;
			}		
		});
		
		// # 3 with Lambda
		printEmployees35OrOlder(employees, e -> e.getAge() >= 35 );
		
		
	}

	// this method prints all the employees ONLY if they're 35 or older
	private static void printEmployees35OrOlder(List<Employee> employees, Predicate<Employee> ageCondition) {
		
		employees.forEach(e -> {
			
			if (ageCondition.test(e)) {
				System.out.println(e + " RETUEND TRUE FOR THE PREDICATE AGE CONDITION");
			}
			
		});
		
	}

}

class EmployeeAgeChecker implements Predicate<Employee> {

	@Override
	public boolean test(Employee e) {

		return e.getAge() >= 35 ? true : false;
	}

}
