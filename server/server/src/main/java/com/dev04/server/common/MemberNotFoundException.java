package com.dev04.server.common;

public class MemberNotFoundException extends RuntimeException{
	
	public MemberNotFoundException(String message) {
		super (message);
	}

}
