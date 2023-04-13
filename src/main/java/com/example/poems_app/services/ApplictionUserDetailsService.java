package com.example.poems_app.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.poems_app.entities.User;
import com.example.poems_app.models.UserPrincipal;

@Service
public class ApplictionUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		return new UserPrincipal(
				userService.searchByEmail(email));
	}
	
	private Boolean verifyPasswordHash(String pwd, byte[] storedHash, byte[] storedSalt) throws NoSuchAlgorithmException {
		if (pwd.isBlank() || pwd.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		if (storedHash.length != 64) {
			throw new IllegalArgumentException();
		}
		
		if (storedSalt.length != 64) {
			throw new IllegalArgumentException();
		}
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
	    md.update(storedSalt);
	    
	    byte[] computedHash = md.digest(pwd.getBytes(StandardCharsets.UTF_8));
	    
	    return MessageDigest.isEqual(computedHash, storedHash);
		
	}
	
	public User authenticate(String email, String pwd) throws NoSuchAlgorithmException {
		if (email.isEmpty() || pwd.isEmpty()) {
			throw new BadCredentialsException("Unauthorized");
		}
		
		User user = userService.searchByEmail(email);
		
		if (user == null) {
			throw new BadCredentialsException("Unauthorized");
		}
		
		Boolean verified = verifyPasswordHash(pwd,user.getStoredHash(),user.getStoredSalt());
		
		if (!verified) {
			throw new BadCredentialsException("Unauthroized");
		}
		
		return user;
		
	}
    
}
