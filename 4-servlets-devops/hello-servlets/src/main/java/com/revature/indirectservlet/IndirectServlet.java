package com.revature.indirectservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *InterServelt Communication
 */
public class IndirectServlet extends HttpServlet {

	// IF this servlet receives GET request, we REDIRECT it to the direct servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// we redirect the responsibility of handling the HTTP Request and deliver the request to another resource
		response.sendRedirect("http://localhost:8080/hello-servlets/dirserv"); 
		
		System.out.println("We triggered() the doGet() method within IndirectServlet and redirected to DirectServlet");
	
		System.out.println("Context Example: " + getServletContext().getInitParameter("contextExample"));
		System.out.println("Config Example: " + getServletConfig().getInitParameter("contextExample"));
	
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// another way of facilitating interservlet communication
		RequestDispatcher rdis = request.getRequestDispatcher("/dirserv");
		
		rdis.forward(request, response); // we are forwarding both the request and response objects to the new resource
		
		System.out.println("We triggered() the doPost() method within IndirectServlet and redirected to DirectServlet");
	}
	
	/*
	 * Here is a list of major differences between servlet forward and
	 * sendRedirect()
	 * 
	 * sendRedirect():
	 * 
	 * The request is redirected to a different resource The client will see the URL
	 * change after the redirect A totally new request is created Redirect is
	 * normally used within Post/Redirect/Get web development pattern
	 *
	 * 
	 * forward():
	 * 
	 * The request will be further processed on the server side. The client isn't
	 * impacted by forward, 
	 * 
	 * - URL in a browser stays the same (doesn't change based on the resource that you forwarded to) 
	 * - Request and response objects will remain the same object after forwarding. 
	 * - Request-scope objects
	 * will be still available
	 */
	
	

}
