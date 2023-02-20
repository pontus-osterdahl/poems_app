package com.example.poems_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.poems_app.BibItem;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface BibItemRepository extends CrudRepository<BibItem, Integer> {

	Iterable<BibItem> findByTitle(String title);
	Iterable<BibItem> findByPoems_id(int id);
	
}
