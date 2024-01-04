package com.movieapp.daos;

import java.util.List;
import java.util.Optional;

import com.movieapp.pojos.Movie;

public interface IMovieDao extends AutoCloseable {
	public List<Movie> findAll() throws Exception;
	    
	public Optional<Movie> findById(int id) throws Exception;
}
