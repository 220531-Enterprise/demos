package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		final String URI = request.getRequestURI().replace("/movie-app/", "");
		
		switch(URI) {
		
		case "addmovie":
			System.out.println("Request helper for addMovie triggered");
			// invoke some function from the RequestHelper
			RequestHelper.addMovie(request, response);
			break;
			
		case "login":
			System.out.println("Request helper for login triggered");
			// invoke some function from the RequestHelper
			RequestHelper.processLogin(request, response);
			break;
			
		case "getmovies":
			System.out.println("Request helper for getmovies triggered");
			// invoke some function from the RequestHelper
			RequestHelper.getFavoriteMovies(request, response);
			break;
			
		default:
			// custom error page
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
