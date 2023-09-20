package com.example.poems_app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.poems_app.xml.ContentItem;

public interface ContentItemRepository extends CrudRepository<ContentItem, Integer> {
    Optional<ContentItem> findByTextId(String textid);
    
    //Iterable<ContentItem> findByXmlPoemId(int id);
}
