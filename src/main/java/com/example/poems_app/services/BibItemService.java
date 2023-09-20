package com.example.poems_app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poems_app.BibItem;
import com.example.poems_app.Poem;
import com.example.poems_app.repositories.BibItemRepository;

@Service
public class BibItemService implements BeanService<BibItem> {

	@Autowired
	private BibItemRepository bibItemRepository;
	
	@Override
	public Optional<BibItem> getById(int id) {
		return bibItemRepository.findById(id);
	}

	@Override
	public Iterable<BibItem> getAll() {
		return bibItemRepository.findAll();
	}

	@Override
	public BibItem add(BibItem item) {
		// TODO Auto-generated method stub
		return bibItemRepository.save(item);
	}

	@Override
	public BibItem update(BibItem item) {
		// TODO Auto-generated method stub
		return bibItemRepository.save(item);
	}

	@Override
	public Iterable<BibItem> addItems(Iterable<BibItem> items) {
		// TODO Auto-generated method stub
		return bibItemRepository.saveAll(items);
	}
	
	public Optional<BibItem> getByIdentifier(String identifier) {
		return bibItemRepository.findByIdentifier(identifier);
	}

}
