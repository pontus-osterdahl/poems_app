package com.example.poems_app.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.example.poems_app.entities.User;
import com.example.poems_app.xml.XmlPoem;

public interface UserRepository extends CrudRepository<User, UUID>{
	Optional<User> findByEmail(String email);
}
