package com.revature.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet; // this is the Servlet API we added to our POM.xml
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;

/**
 * This class is a Servlet class
 * This class extends server side capabilities of a Java program.
 * ...meaning we can accept an HTTP request and delvier a repsonse directly to the client

 */
public class DirectServlet extends HttpServlet { // HttpServlet extends GenericServlet which 
											    // implements Servlet Interface

	// I want to handle a GET request from a client and return an html page
	// "generated on the fly"
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// here we formulate the reposne for this program to send BACK to a client
		
		response.setContentType("text/html");
		
		// use a PrintWrite to dynamically write the response to the client
		// A PrintWriter can be obtained from a response object and used to print text data to a character stream
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>The Servlet is talking directly to the client!</h2></body></html>");

	}
	
	
	/**
	 * When this servlet is hit with a POST request, this method will be invoked
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// send a Java object in JSON (JavaScript Object Notation)
		// JSON is a data interchange format
		
		// We need an Object Mapper to take a Java Object and transform it 
		// into an object that could be read by a browser (or app running in a browser) 
		
		// Step 1. set the repsonse type to JSON
		response.setContentType("application/json");
		
		// Step 2. Instantitate the object
		SuperVillain vill = new SuperVillain("The Penguin", "money", 9000.02);
		
		// Step 3. Transform the Java Object to JSON (MARSHALL IT) using our Object Mapper
		String jsonString = new ObjectMapper().writeValueAsString(vill);
		// ObjectMapper comes from Jackson Databind dependency
		
		// Step 4. write it out
		PrintWriter out = response.getWriter(); // grab the PrintWriter
		out.write(jsonString); // the print writer just prints data to the client
		
	
	}
	
	
	
}













