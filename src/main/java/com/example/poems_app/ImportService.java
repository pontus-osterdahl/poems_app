package com.example.poems_app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poems_app.factories.QueryInterfaceFactory;
import com.example.poems_app.queryInterfaces.QueryInterface;
import com.example.poems_app.repositories.BibItemSourceRepository;

@Service
public class ImportService {

	@Autowired
	private BibItemSourceRepository repository;
	
	public List<BibItem> getBibItems (BibItemSource bibItemSource, String query) {
		
		String interfaceType = bibItemSource.getInterfaceType();
		QueryInterface queryInterface = QueryInterfaceFactory.getQueryInterface(interfaceType);
		return queryInterface.performQuery(bibItemSource.getHost(), query);
	}
	
	public Iterable<BibItemSource> saveBibItemSources (Iterable<BibItemSource> bibItemSources) {
		return repository.saveAll(bibItemSources);
	}
	
	public BibItemSource saveBibItemSource(BibItemSource bibItemSource) {
		return repository.save(bibItemSource);
	}
	
	public BibItemSource updateBibItemSource(BibItemSource bibItemSource) {
		return repository.save(bibItemSource);
	}
	
	public Optional<BibItemSource> findBibItemSourceById(int id) {
		return repository.findById(id);
	}
	
	public Iterable<BibItemSource> findAllBibItemSources() {
		return repository.findAll();
	}
	
	public void deleteBibItemSourceById(int id) {
		repository.deleteById(id);
	}

}
