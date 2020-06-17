package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.cognizant.moviecruiser.exception.FavoritesCartEmptyException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.exception.UserNotExistException;
import com.cognizant.moviecruiser.model.Movie;

public interface FavoritesDao {
	
	public void addToFavoritesCart(String userId, int movieId) throws MovieNotFoundException;
	public HashMap<ArrayList<Movie>,Integer> getAllFavoriteMovies(String userId) throws UserNotExistException, FavoritesCartEmptyException;
	public void deleteFavoriteMovie(String userId, int movieId)throws UserNotExistException, FavoritesCartEmptyException, MovieNotFoundException;

}
