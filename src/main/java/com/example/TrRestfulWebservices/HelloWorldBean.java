package com.example.TrRestfulWebservices;

public class HelloWorldBean {

	private String message;

//	Constructor which accepts a simple message
	public HelloWorldBean(String message) {
		this.message = message;
	}

//	If we haven't wrote the getter we will get the 
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	
}
