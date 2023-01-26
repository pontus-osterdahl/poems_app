package com.example.poems_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.poems_app.Book;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface BookRepository extends CrudRepository<Book, Integer> {

	Iterable<Book> findByTitle(String title);
	
}