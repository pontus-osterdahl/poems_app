package com.example.poems_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.poems_app.Article;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
    Iterable<Article> findByTitle(String title);
}
