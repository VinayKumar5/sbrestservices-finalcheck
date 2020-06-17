package com.cognizant.moviecruiser.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.exception.InActiveException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class MovieService {
	
	@Autowired
	private MovieDao movieDao;
	
	public ArrayList<Movie> getMoviesList()
	{
		return movieDao.getMoviesList();
	}
	
	public Movie getMovie(int movieId)throws MovieNotFoundException
	{
		return movieDao.getMovie(movieId);
	}
	
	public ArrayList<Movie> getActiveLaunchNotInFutureMovies()throws InActiveException
	{
		return movieDao.getActiveLaunchNotInFutureMovies();
	}
	
	public void modifyMovieDetails(Movie movie)throws MovieNotFoundException
	{
		movieDao.modifyMovieDetails(movie);
	}
	
}
