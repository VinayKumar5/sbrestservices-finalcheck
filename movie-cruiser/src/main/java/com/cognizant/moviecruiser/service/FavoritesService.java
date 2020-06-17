package com.cognizant.moviecruiser.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.exception.FavoritesCartEmptyException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.exception.UserNotExistException;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class FavoritesService {
	
	@Autowired
	private FavoritesDao favoritesDao;
	
	public void addToFavoritesCart(String userId, int movieId) throws MovieNotFoundException	
	{
		favoritesDao.addToFavoritesCart(userId, movieId);
		
	}
	
	public HashMap<ArrayList<Movie>, Integer> getAllFavoriteMovies(String userId) throws UserNotExistException, FavoritesCartEmptyException
	{
		return favoritesDao.getAllFavoriteMovies(userId);		
	}
	
	public void deleteFavoriteMovie(String userId, int movieId)throws UserNotExistException, FavoritesCartEmptyException, MovieNotFoundException
	{
		favoritesDao.deleteFavoriteMovie(userId, movieId);
	}
	
}
