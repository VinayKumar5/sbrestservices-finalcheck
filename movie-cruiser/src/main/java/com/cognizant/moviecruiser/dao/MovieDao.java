package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;

import com.cognizant.moviecruiser.exception.InActiveException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

public interface MovieDao {
	
	public ArrayList<Movie> getMoviesList();	
	public Movie getMovie(int movieId) throws MovieNotFoundException;
	public ArrayList<Movie> getActiveLaunchNotInFutureMovies() throws InActiveException;
	public void modifyMovieDetails(Movie movie)throws MovieNotFoundException;

}
