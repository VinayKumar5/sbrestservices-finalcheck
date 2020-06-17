package com.cognizant.moviecruiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cart is Empty")
public class FavoritesCartEmptyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FavoritesCartEmptyException(String msg)
	{
		super(msg);
	}

}
