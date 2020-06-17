package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.cognizant.moviecruiser.exception.FavoritesCartEmptyException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.exception.UserNotExistException;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

@Component
public class FavoritesDaoCollectionImpl implements FavoritesDao{
	
	private HashMap<String, Favorites> userFavoritesCart;
	
	

	public FavoritesDaoCollectionImpl() {
		super();
		userFavoritesCart=new HashMap<String, Favorites>();
	}



	@Override
	public void addToFavoritesCart(String userId, int movieId) throws MovieNotFoundException {
		
		MovieDao movieDao = new MovieDaoCollectionImpl();
		Movie movie=movieDao.getMovie(movieId);
		
		if(movie==null)
		{
			throw new MovieNotFoundException("Movie Not Found");
			
		}
		else
		{
			if(userFavoritesCart.containsKey(userId))
			{
				ArrayList<Movie> movieList=userFavoritesCart.get(userId).getFavoriteMovies();
				movieList.add(movie);
			}
			else
			{
				Favorites favorites=new Favorites();
				favorites.getFavoriteMovies().add(movie);
				userFavoritesCart.put(userId,favorites);
			}
		}		
				
	}



	@Override
	public HashMap<ArrayList<Movie>, Integer> getAllFavoriteMovies(String userId)throws UserNotExistException, FavoritesCartEmptyException {
		HashMap<ArrayList<Movie>, Integer> map=null;
		if(!userFavoritesCart.containsKey(userId)) {
			
			throw new UserNotExistException("User Not Found");		
		}
		
		Favorites favorites=userFavoritesCart.get(userId);
		ArrayList<Movie> movieList=favorites.getFavoriteMovies();
		int totalFavorites=0;
		
		totalFavorites=movieList.size();
		if(totalFavorites==0)
		{
			throw new FavoritesCartEmptyException("Cart is Empty");
		}
		
		map=new HashMap<ArrayList<Movie>,Integer>();
		map.put(movieList,totalFavorites);			
		return map;
	}



	@Override
	public void deleteFavoriteMovie(String userId, int movieId)throws UserNotExistException, FavoritesCartEmptyException, MovieNotFoundException
	{
		
		if(userFavoritesCart.containsKey(userId))
		{
			ArrayList<Movie> list=userFavoritesCart.get(userId).getFavoriteMovies();	
			if(list.isEmpty())
				throw new FavoritesCartEmptyException("Cart is Empty");
				
			boolean isDeleted=false;
			for(Movie m:list)
			{
				if(m.getId()==movieId)
				{
					list.remove(m);
					isDeleted=true;
				}
			}
			
			if(!isDeleted)
			{
				throw new MovieNotFoundException("Movie Not Found");
			}
		}
		else
		{
			throw new UserNotExistException("User Not Found"); 			
		}
		
	}

}
