package com.revature.service;

import com.revature.dao.IMovieDao;
import com.revature.models.Movie;

public class MovieService {

	private IMovieDao mdao;

	public MovieService(IMovieDao mdao) {
		this.mdao = mdao;
	}
	
	public Movie addMovie(Movie m) {
		 int pk = mdao.insert(m);
		 m.setId(pk);
		 return m;
	}

}
