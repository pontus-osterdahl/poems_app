package com.example.poems_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.poems_app.xml.ContentItemChoice;

public interface ChoiceRepository extends CrudRepository<ContentItemChoice, Integer> {

}
