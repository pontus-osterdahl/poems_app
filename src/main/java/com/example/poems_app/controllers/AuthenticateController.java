package com.example.poems_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.poems_app.entities.User;
import com.example.poems_app.models.AuthenticationRequest;
import com.example.poems_app.models.AuthenticationResponse;
import com.example.poems_app.services.ApplictionUserDetailsService;
import com.example.poems_app.util.JwtUtil;

@RestController
public class AuthenticateController {
/**
	//private AuthenticationManager authenticationManager = new AuthenticationManager();
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private ApplictionUserDetailsService userDetailsService;
	
	@RequestMapping(value ="/authenticate")
	public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest req) throws Exception {
		User user;
		
		try {
			user = userDetailsService.authenticate(req.getEmail(), req.getPassword());
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
		
		String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return new AuthenticationResponse(jwt);
		
	}
	
*/	
}
