package com.example.poems_app.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.poems_app.dto.UserDTO;
import com.example.poems_app.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/api/users")
	public Iterable<UserDTO> getUsers() {
		return userService.findAllUsers();
	}
	
	@GetMapping("/api/users/{id}")
	public UserDTO getUserById(@PathVariable("id") UUID id) throws Exception {
		return userService.findUserById(id);
	}
	
	@DeleteMapping("/api/users/{id}")
	public UserDTO deleteUserById(@PathVariable("id") UUID id) throws Exception {
		return userService.findUserById(id);
	}
	
	@PostMapping("/register")
	public UserDTO postUser(@Valid @RequestBody UserDTO user) throws NoSuchAlgorithmException {
		return userService.createUser(user, user.getPassword());	
	}
	
	@PutMapping("/api/users/{id}")
	public void putUser(@PathVariable("id") UUID id, @Valid @RequestBody UserDTO user) throws Exception {
		userService.updateUser(id, user, user.getPassword());	
	}
	
}
