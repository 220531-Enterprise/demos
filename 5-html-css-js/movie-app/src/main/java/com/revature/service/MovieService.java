package com.revature.service;

import java.util.List;

import com.revature.dao.IMovieDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.Movie;
import com.revature.models.User;

public class MovieService {

	private IMovieDao mdao;
	private static UserService userv = new UserService(new UserDaoImpl());

	public MovieService(IMovieDao mdao) {
		this.mdao = mdao;
	}
	
	public Movie addMovie(Movie m) {
		 int pk = mdao.insert(m);
		 m.setId(pk);
		 return m;
	}
	
	public List<Movie> getMoviesByUserId(int userId) {
		
		User u = userv.getById(userId);
		List<Movie> movies = u.getMovies();
		
		return movies;
	}

}
