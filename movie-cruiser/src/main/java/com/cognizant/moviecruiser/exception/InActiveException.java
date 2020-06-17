package com.cognizant.moviecruiser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Movie Not Found")
public class InActiveException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InActiveException(String msg)
	{
		super(msg);
	}
	
	

}
