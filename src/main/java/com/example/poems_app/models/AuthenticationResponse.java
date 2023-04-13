package com.example.poems_app.models;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

	private String token;

	public AuthenticationResponse(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
