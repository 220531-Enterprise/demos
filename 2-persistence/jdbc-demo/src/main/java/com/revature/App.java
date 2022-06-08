package com.revature;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.service.UserService;

public class App {

	private static Logger logger = Logger.getLogger(App.class);

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

//		logger.info("Starting application......");
//		
//		ConnectionUtil.getConnection();
//		
//		User u1 = new User("tonystark", "ironman",  Role.Admin, new ArrayList<Account>());
//		
//		UserDaoImpl uDao = new UserDaoImpl();
//		
//		uDao.insert(u1);
		
		menu();

	}

	static void menu() {

		UserService uservice = new UserService();

		System.out.println("Welcome! Please press 1 if you'd like to login or 2 if you'd like to register");

		int input = scan.nextInt();

		if (input == 1) {

			int counter = 5;

			while (counter > 0) {

				// capture their username
				System.out.println("Please enter your username");
				String username = scan.next();

				// capture their password
				System.out.println("Please enter your password");
				String password = scan.next();

				// call the login() method with both of these values
				User loggedInUser = uservice.login(username, password); // make login() and register() public

				if (loggedInUser == null) {
					// since we want to print a msg to the user
					System.out.println("username and password incorrect, please try again");
					counter --; 
				} else {
					System.out.println("Welcome " + username + "You have successfully logged in");
					counter = -1; // break from the loop 
				}

			}
			
			// if we break out of the l0op and the counter is  > -1 (meaning 0)
			if(counter > -1) {
				System.out.println("Ending your chance at logging in ~ Goodbye!!!");
				System.exit(0); // ending the program with no technical problems
			}
			
			// You could say something like
			// System.out.println("If you would like to make a deposit....");
			
		} else if (input == 2) {
			
			User newUser = new User();
			
			System.out.println("Enter a username to register with:");
			String username = scan.next();
			
			System.out.println("Enter a password to register with:");
			String password = scan.next();
			
			// you guys will need some logic for determining ROLE
			
			// for right now we'll assume that they are a customer by default
			
			// set the props of the new user
			newUser.setUsername(username);
			newUser.setPwd(password);
			newUser.setRole(Role.Customer);
			
			// One other way of doing it would be with the constructor
			// User registeredUser = new User(username, password, Role.Customer, null);
			
			
			try {
				uservice.register(newUser); // persists the new User to eh database
			} catch (RegisterUserFailedException e) {
				// in the case that the Exception is thrown and we can't register our User...
				logger.warn(e.getMessage());
				// also warn the user
				System.out.println("Hmm seems like you already exist in the DB");
			}
			
			// the rest of what you do here is up to you
		}

	}

}
