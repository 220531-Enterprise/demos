package com.revature;

import org.apache.log4j.Logger; // import from org.apache.Log4J

public class LoggingDemo {
	
	// Step 1. Declare a Logger  at the static level of the class you'd like to use it in
	private static Logger logger = Logger.getLogger(LoggingDemo.class);

	public static void main(String[] args) {
		
		/**
		 * What is Logging?
		 * Logging is a method of reporting information during the execution of a program (runtime)
		 * We typically use log files to inform devs and System Admins about what's happening within the program.
		 * 
		 * We have Several Logging Levels:
		 * 
		 * OFF: No logging at all
		 * ALL: Turns on all levels of logging
		 * TRACE: Adds more information to our DEBUG logs
		 * DEBUG: Primarily a logging level that is helpful for Developers (turn on all of the following levels)
		 * INFO: Represent important business processes, used for defining when they have completed
		 * 		and that the current application state is "as expected"
		 * 		Generally speaking, System Administrators as well as similar roles (such as SREs) will monitor INFO logs to track
		 * 		the Application Status
		 * 
		 * WARN: Suggest that the application might be continued, but you should take extra caution
		 * ERROR: Shouting that something has gone very wrong and should be investigated immediately
		 * FATAL: Very rare, but signals that something is terribly wrong, and will likely result in application failure
		 */
		
		// Step 2 Use the logger
		logger.info("Application has started.....");
		
		try {
			recursiveMethod();
		} catch (Error err) {
			//  java.lang.StackOverflowError
			logger.error("Something has gone horribly wrong");
			
		}
		

	}
	
	static void recursiveMethod() {
		// recursion is when a method calls itself;
		recursiveMethod();
	}
	

}





