package com.revature.indirectservlet;

import java.io.IOException;
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
