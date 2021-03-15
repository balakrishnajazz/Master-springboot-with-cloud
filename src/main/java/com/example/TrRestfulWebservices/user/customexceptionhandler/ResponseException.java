package com.example.TrRestfulWebservices.user.customexceptionhandler;

import java.util.Date;

public class ResponseException {
	
	private Date date;
	private String message;
	private String details;
	public ResponseException(Date date, String message, String details) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
	}
	public Date getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	
}
