package com.example.poems_app.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.poems_app.dto.UserDTO;
import com.example.poems_app.entities.User;
import com.example.poems_app.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	UserRepository repo;
	
	private UserDTO convertToDTO(User user)  {
		return mapper.map(user, UserDTO.class);
	}
	
	private User convertToUser(UserDTO user)  {
		return mapper.map(user, User.class);
	}
	
	
	public List<UserDTO> findAllUsers() {
		List<User> users = Streamable.of(repo.findAll()).toList();
		return users
				.stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	public User searchByEmail(String email) throws UsernameNotFoundException {
		return repo.findByEmail(email)
				.orElseThrow(
						() -> new UsernameNotFoundException("User " + email + " could not be found")
						);
	}
	
	public UserDTO findUserById(final UUID id) throws Exception {
		User user = repo
				.findById(id)
				.orElseThrow(
				    () -> new Exception()		
				);
		
		return convertToDTO(user);
	}
	
	private byte[] createSalt() {
	    SecureRandom random = new SecureRandom();
	    byte[] salt = new byte[128];
	    random.nextBytes(salt);
	    
	    return salt;
	}
	
	private byte[] createPasswordHash(String password, byte[] salt) throws NoSuchAlgorithmException {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt);
			
			return md.digest(
			    password.getBytes(StandardCharsets.UTF_8));
	}
	
	public UserDTO createUser(UserDTO userDTO, String password) throws NoSuchAlgorithmException{
		User user = convertToUser(userDTO);
		
		if (password.isBlank()) {
			throw new IllegalArgumentException();
		}
		
		byte[] salt = createSalt();
		byte[] hashedPassword = createPasswordHash(password, salt);
		
		user.setStoredSalt(salt);
		user.setStoredHash(hashedPassword);
		
		repo.save(user);
		
		return convertToDTO(user);
	}
	
	public void updateUser(UUID id, UserDTO userDTO, String password) throws Exception {
		User user = findOrThrow(id);
		User userParam = convertToUser(userDTO);
		
		user.setEmail(userParam.getEmail());
		
		if (!password.isBlank()) {
			byte[] salt = createSalt();
			byte[] hashedPassword = createPasswordHash(password, salt);
			user.setStoredSalt(salt);
			user.setStoredHash(hashedPassword);
		}
		repo.save(user);
	}
	
	public void removeUserBydId(UUID id) throws Exception {
		findOrThrow(id);
		repo.deleteById(id);
	}
	
	
	private User findOrThrow(final UUID id) throws Exception {
	return repo.findById(id)
			.orElseThrow(() -> new Exception());
	}
}


