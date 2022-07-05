package com.revature.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.revature.dao.MovieDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.models.Movie;
import com.revature.models.User;
import com.revature.service.MovieService;
import com.revature.service.UserService;

public class RequestHelper {

	private static MovieService mserv = new MovieService(new MovieDaoImpl());
	private static UserService userv = new UserService(new UserDaoImpl());

	public static void processLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();

		Gson gson = new Gson();
		gson = new GsonBuilder().create();
		JsonObject params = new JsonObject();
		

		try {

			JsonParser jsonParser = new JsonParser();
			JsonElement root = jsonParser.parse(new InputStreamReader((InputStream) request.getInputStream()));
			JsonObject jsonobj = root.getAsJsonObject();

			String username = jsonobj.get("username").getAsString();
			String password = jsonobj.get("password").getAsString();

			User user = userv.confirmLogin(username, password);

			if (user != null) {

				System.out.println("found user!");
				HttpSession session = request.getSession();
				session.setAttribute("userId", user.getId());	
				params.addProperty("status", "login success");
				String json = gson.toJson(user);			

				pw.write(json);

			} else {
				params.addProperty("status", "process failed");
				String json = gson.toJson(params);
				pw.write(json);
			}

		} catch (Exception e) {
			params.addProperty("status", "process failed");
			String json = gson.toJson(params);
			pw.write(json);
		}
	}
	
	public static void getFavoriteMovies(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		System.out.println("in the request helper, getting favorite movies");
		
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");

		PrintWriter pw = response.getWriter();

		Gson gson = new Gson();
		gson = new GsonBuilder().create();
		JsonObject params = new JsonObject();
		

		try {

			JsonParser jsonParser = new JsonParser();
			JsonElement root = jsonParser.parse(new InputStreamReader((InputStream) request.getInputStream()));
			JsonObject jsonobj = root.getAsJsonObject();

			int userId = jsonobj.get("userId").getAsInt();


			List<Movie> movies = mserv.getMoviesByUserId(userId);

			if (movies != null) {

				String json = gson.toJson(movies);			

				pw = response.getWriter();
				pw.write(json);

			} else {
				params.addProperty("status", "process failed");
				String json = gson.toJson(params);
				pw.write(json);
			}

		} catch (Exception e) {
			params.addProperty("status", "process failed");
			String json = gson.toJson(params);
			pw.write(json);
		}
	}
	

	public static void addMovie(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");

		System.out.println("in the addMovie method within request helper");

		/**
		 * We're using GSON here because it's easier to use for parsing a payload.
		 */
		Gson gson = new Gson();
		gson = new GsonBuilder().create();
		JsonObject payload = new JsonObject();

		JsonParser jsonParser = new JsonParser();
		// parse the payload of the HTTP request
		JsonElement root = jsonParser.parse(new InputStreamReader((InputStream) request.getInputStream()));
		// Transform payload string to json object
		JsonObject rootobj = root.getAsJsonObject();

		System.out.println(rootobj);

		// extract properties of JSON object
		String title = rootobj.get("title").getAsString();
		String urlImg = rootobj.get("imageUrl").getAsString();
		int rating = rootobj.get("rating").getAsInt();

		Movie m = new Movie(title, urlImg, rating);

		// persist movie to DB and get ID
		m = mserv.addMovie(m);

		System.out.println("We successfully added the movie: " + m);

		// return the persisted movie object to the client
		PrintWriter pw = response.getWriter();
		String json = gson.toJson(m); // this is what we would use Jackson Object Mapper for
		pw.write(json);
	}
}
