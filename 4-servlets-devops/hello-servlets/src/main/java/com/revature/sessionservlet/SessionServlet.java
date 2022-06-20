package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;

public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * When this Servlet is hit with a GET request,  it pushes a hard coded object to the session
	 * This method STORES an object TO THE SESSION
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// instantiate a villain object
		SuperVillain vill = new SuperVillain("Mud Man", "super mud armor", 5.25);
		
		// capture the HttpSession from the request object
		HttpSession session = request.getSession();
		
		// save the villain object to the session
		session.setAttribute("the-villain", vill); // we're setting a key to this object so that other servlets can grab the object
												   // from the session
		
		// use the print writer to print out the the browser that there's a villain on the loose (in the session)
		PrintWriter out = response.getWriter();
		String jsonString = new ObjectMapper().writeValueAsString(vill); // use Jackson databind to marshall the obj
		out.println("The session is set and Mud Man is on the loose!!! Here's his info in JSON: " + jsonString);
		
		
	}

	
	// This method will capture the parameters of the HTTP request body when we send
	// a CUSTOM villain to the session (by way of the user filling out the form in the index.html)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Extract the params from the request and store them in a variable
		String name = request.getParameter("vill-name");
		String superpower = request.getParameter("superpower");
		double bounty = Double.parseDouble(request.getParameter("bounty"));
		
		// 2. Instantiate a SuperVillain object  with those variables passed thru a constructor
		SuperVillain vill = new SuperVillain(name, superpower, bounty);
		
		// 3, Grab the HTTP Session from the request object
		HttpSession session = request.getSession(); // the client sends the request  which possesses a session property
		
		
		// Stored it in the DB -- called the Service layer which called the DAO which persisted the object into the DB
		
		// 4. Set "the-villain" name to the object by calling session.setAttrbiute()
		session.setAttribute("the-villain", vill);
		
		// 5. Print out to the client that a villain has been set to the session
		PrintWriter out = response.getWriter();
		out.println("A villain is on the loose...in the session");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
