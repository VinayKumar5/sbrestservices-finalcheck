package com.cognizant.moviecruiser.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.exception.InActiveException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/")
	public ArrayList<Movie> getMoviesList()
	{
		LOGGER.info("Start");
		LOGGER.info("in getMoviesList()");
		LOGGER.info("End");
		return movieService.getMoviesList();
	}
	
	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable int movieId)throws MovieNotFoundException
	{
		LOGGER.info("Start");
		LOGGER.info("in getMovie()");
		LOGGER.info("End");
		return movieService.getMovie(movieId);
	}
	
	@GetMapping("/activenow")
	public ArrayList<Movie> getActiveLaunchNotInFutureMovies()throws InActiveException
	{
		LOGGER.info("Start");
		LOGGER.info("in getActiveLaunchNotInFutureMovies()");
		LOGGER.info("End");
		return movieService.getActiveLaunchNotInFutureMovies();
	}
	
	@PutMapping()
	public void modifyMovieDetails(@RequestBody Movie movie)throws MovieNotFoundException
	{
		LOGGER.info("Start");
		LOGGER.info("in modifyMovieDetails()");
		movieService.modifyMovieDetails(movie);
		LOGGER.info("End"); 
	}

}
