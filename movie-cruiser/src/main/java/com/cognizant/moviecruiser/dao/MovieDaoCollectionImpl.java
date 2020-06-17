package com.cognizant.moviecruiser.dao;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.moviecruiser.exception.InActiveException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

@Component
public class MovieDaoCollectionImpl implements MovieDao{
	
	private	ArrayList<Movie> movieList=null;
	private ClassPathXmlApplicationContext context;
	
	public MovieDaoCollectionImpl()
	{
		super();
		context = new ClassPathXmlApplicationContext("movie.xml");		
		movieList = (ArrayList<Movie>)context.getBean("movieList", java.util.ArrayList.class);
		context.close();
	}

	@Override
	public ArrayList<Movie> getMoviesList() {		
		return movieList;
	}

	@Override
	public Movie getMovie(int movieId)throws MovieNotFoundException {
		Movie movie=null;
		boolean found=false;
		for(Movie m:movieList)
		{
			if(m.getId()==movieId)
			{
				movie=m;
				found=true;
				break;
			}
		}
		if(!found)
				throw new MovieNotFoundException("Movie Not Found");
		return movie;
	}

	@Override
	public ArrayList<Movie> getActiveLaunchNotInFutureMovies()throws InActiveException
	{
		ArrayList<Movie> activeMovies=new ArrayList<Movie>();
		Date current=new Date(System.currentTimeMillis());
		System.out.println(current);		
		for(Movie m:movieList)
		{
			//System.out.println(current+" "+ m.getDateOfLaunch());
			
			if(m.isActive() && current.after(m.getDateOfLaunch()))
				{
					//System.out.println(m);
								
					activeMovies.add(m);				
				}
		}
		
		if(activeMovies.size()==0)
		{
			throw new  InActiveException("No Acive Movies Found");						
		}			
		return activeMovies;
	}

	@Override
	public void modifyMovieDetails(Movie movie)throws MovieNotFoundException  {
		
		int index=0;
		boolean found=false;
		
		for(Movie m:movieList)
		{
			if(movie.getId()==m.getId())
			{
				found=true;
				break;
			}
		}
		
		if(!found)
		{
			throw new MovieNotFoundException("Movie Not Found");			
		}
		else
		{
			movieList.set(index, movie);
		}
		
	}	
	
		

}
