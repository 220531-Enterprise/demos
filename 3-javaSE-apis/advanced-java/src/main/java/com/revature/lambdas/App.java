package com.revature.lambdas;

import java.util.ArrayList;
import java.util.List;

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

	}

}
