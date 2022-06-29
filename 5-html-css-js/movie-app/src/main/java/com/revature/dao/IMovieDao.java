package com.revature.dao;

import java.util.List;

import com.revature.models.Movie;

public interface IMovieDao {

	int insert(Movie m);
	
	Movie selectById(int id);
	
	List<Movie> selectAll();
	
	List<Movie> selectByUserId(int userId);
}