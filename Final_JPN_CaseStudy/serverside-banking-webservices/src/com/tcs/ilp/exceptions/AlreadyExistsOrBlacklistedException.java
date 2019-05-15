package com.tcs.ilp.exceptions;

public class AlreadyExistsOrBlacklistedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AlreadyExistsOrBlacklistedException(String message){
		super(message);
	}

	
}
