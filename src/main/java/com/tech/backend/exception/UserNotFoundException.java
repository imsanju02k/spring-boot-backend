package com.tech.backend.exception;

public class UserNotFoundException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(Long id) {
		super ("Could not found the user with id + " +id);
	}

}
