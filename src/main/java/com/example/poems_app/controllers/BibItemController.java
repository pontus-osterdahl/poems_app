package com.example.poems_app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.poems_app.Article;
import com.example.poems_app.BibItem;
import com.example.poems_app.Book;
import com.example.poems_app.Image;
import com.example.poems_app.repositories.ArticleRepository;
import com.example.poems_app.repositories.BibItemRepository;
import com.example.poems_app.repositories.BookRepository;

@RestController
public class BibItemController {

	
	@Autowired
	BibItemRepository repository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	ArticleRepository articleRepository;
	
	@CrossOrigin
	@GetMapping("/bibItem/{isbn}")
	public BibItem getByISBN(@PathVariable int isbn) {
		return null;
	}
	
	@CrossOrigin
	@GetMapping("/bibItem/title/{title}")
	public Iterable<BibItem> getSelectionByTitle(@PathVariable String title) {
		return repository.findByTitle(title);
	}
	
	@CrossOrigin
	@PostMapping("/bibItem/book")
	public Book saveBook(@RequestBody Book bibItem) {
		return bookRepository.save(bibItem);
	}
	
	@CrossOrigin
	@PostMapping("/bibItem/article")
	public BibItem saveBook(@RequestBody Article bibItem) {
		return repository.save(bibItem);
	}
	
	@CrossOrigin
	@GetMapping("/bibItem")
	public Iterable<BibItem> getAllBibItems() {
		return repository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/bibItem/poem/{id}")
	public Iterable<BibItem> getBibItemByPoem(@PathVariable int id) {
		return repository.findByPoems_id(id);
	}
	
	
}
