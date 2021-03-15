package com.example.TrRestfulWebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundExcception extends RuntimeException {

	public UserNotFoundExcception(String arg0) {
		super(arg0);
		
	}
	
	
}
