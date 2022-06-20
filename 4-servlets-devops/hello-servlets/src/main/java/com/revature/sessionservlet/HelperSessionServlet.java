package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.SuperVillain;

public class HelperSessionServlet extends HttpServlet {

       

	/**
	 * When we send a GET request here, it will return whatever villain object is stored in the session
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. Grab the session from the request
		HttpSession session = request.getSession();
		
		// 2. Save the object fetched the session to a SuperVillain object
		SuperVillain vill = (SuperVillain) session.getAttribute("the-villain"); // I stored the villain object and set "the-villain" as its name in 
											 // the SessionServlet's doGet() method
		
		// 3. After "capturing" the villain object from the session, print it our via the printwriter
		PrintWriter out = response.getWriter();
	
		// Let's generate an HTML page on the fly
		out.println("<html><body>");
		
		// check if the SuperVillain object retrieved is null or not...if not null, print out its properties
		if (vill != null) {
			
			out.println("We have captured the villain from the session");
			
			// print out all the properties of the object we just captured from the session
			out.println("<h1>Villain Name: " + vill.getName() + "</h1><br />");
			out.println("<b>Super Power: " + vill.getSuperpower() + "</b><br />");
			out.println("<i>Bounty: $" + vill.getBounty() + "</i><br />");
		} else { // in the case that it is null, just print out that you couldn't find any villains
			out.println("<i>Couldn't find any villains</i>");
		}
		
		out.println("</body></html>");
	}


}
