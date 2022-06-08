package com.revature;

import java.util.Scanner;

import org.apache.log4j.Logger;

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
			
			// if we break out of the lop and the counter is  > -1 (meaning 0)
			if(counter > -1) {
				System.out.println("Ending your chance at logging in ~ Goodbye!!!");
				System.exit(0); // ending the program with no technical porblems
			}
			
		}

	}

}
