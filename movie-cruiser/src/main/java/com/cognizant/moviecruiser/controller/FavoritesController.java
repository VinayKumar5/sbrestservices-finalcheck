package com.cognizant.moviecruiser.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.exception.FavoritesCartEmptyException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.exception.UserNotExistException;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.FavoritesService;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FavoritesController.class);
	
	@Autowired
	private FavoritesService favoritesService;
	
	@PostMapping("/{userId}/{movieId}")
	public void addToFavoritesCart(@PathVariable String userId,@PathVariable int movieId)throws MovieNotFoundException
	{
		LOGGER.info("Start");
		LOGGER.info("in addToFavoritesCart()");		
		favoritesService.addToFavoritesCart(userId, movieId);
		LOGGER.info("End");
	}
	
	@GetMapping("/{userId}")
	public HashMap<ArrayList<Movie>,Integer> getAllFavoriteMovies(@PathVariable String userId)throws UserNotExistException, FavoritesCartEmptyException
	{
		LOGGER.info("Start");
		LOGGER.info("in getAllFavoriteMovies()");
		LOGGER.info("End");
		return favoritesService.getAllFavoriteMovies(userId);		
	}
	
	
	@DeleteMapping("/{userId}/{movieId}")
	public void deleteFavoriteMovie(@PathVariable String userId,@PathVariable int movieId)throws UserNotExistException, FavoritesCartEmptyException, MovieNotFoundException
	{
		LOGGER.info("Start");
		LOGGER.info("in deleteFavoriteMovie()");
		favoritesService.deleteFavoriteMovie(userId, movieId);
		LOGGER.info("End");
	}
	

}
