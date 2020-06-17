package com.cognizant.moviecruiser.model;

import java.util.ArrayList;

public class Favorites {

	private ArrayList<Movie> favoriteMovies;
	private int totalFavorites;

	public Favorites() {
		super();
		favoriteMovies=new ArrayList<Movie>();
		totalFavorites=0;
		
	}

	public ArrayList<Movie> getFavoriteMovies() {
		return favoriteMovies;
	}

	public void setFavoriteMovies(ArrayList<Movie> favoriteMovies) {
		this.favoriteMovies = favoriteMovies;
	}

	public int getTotalFavorites() {
		return totalFavorites;
	}

	public void setTotalFavorites(int totalFavorites) {
		this.totalFavorites = totalFavorites;
	}

	@Override
	public String toString() {
		return "Favorites [favoriteMovies=" + favoriteMovies + ", totalFavorites=" + totalFavorites + "]";
	}

}
