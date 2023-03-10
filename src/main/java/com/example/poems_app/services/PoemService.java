package com.example.poems_app.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poems_app.BibItem;
import com.example.poems_app.Indexer;
import com.example.poems_app.IndexerFactory;
import com.example.poems_app.Poem;
import com.example.poems_app.PoemIndexDatabaseSyncher;
import com.example.poems_app.PoemRepository;
import com.example.poems_app.SearchServiceFactory;
import com.example.poems_app.repositories.BibItemRepository;

@Service
public class PoemService implements BeanService<Poem> {
	@Autowired
	private PoemRepository poemRepository;
	
	@Autowired
	private BibItemRepository bibItemRepository;
	
	//private PoemIndexer poemIndexer;

//	private PoemSearchService poemSearchService;

	public Optional<Poem> getById(int id) {
		return poemRepository.findById(id);
	}
	
	public Iterable<Poem> getAll() {
		return poemRepository.findAll();
	}
	
	public Iterable<Poem> getByWord(String word) {
		SearchService<Poem> poemSearchService = SearchServiceFactory.getSearchService("POEM");
	    
		try {
			List<Poem> list = poemSearchService.search(word);
			return list;
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		} 
		return new ArrayList<Poem>();
	}
	
	public Poem add(Poem item) {
		Poem poem = poemRepository.save(item);
		Indexer<Poem> indexer = IndexerFactory.getIndexer("POEM");
		indexer.index(poem);
		return poem;
	}
	
	public Poem update(Poem item) {
		Poem poem = poemRepository.save(item);
		Indexer<Poem> indexer = IndexerFactory.getIndexer("POEM");
		indexer.index(poem);
		return poem;
	}
	
	//How to do when not all are saved to database, should they still be indexed? what should be returned?
	public Iterable<Poem> addItems(Iterable<Poem> items) {
	    Iterable<Poem> savedPoems = poemRepository.saveAll(items);
		Indexer indexer = IndexerFactory.getIndexer("POEM");
		indexer.indexAll(savedPoems);		
		return savedPoems;
	}
	
	public void reIndex() throws SolrServerException, IOException {
		Iterable<Poem> currentIndexPoems = SearchServiceFactory.getSearchService("POEM").getAll();
		new PoemIndexDatabaseSyncher().updateIndex(currentIndexPoems, poemRepository.findAll(), IndexerFactory.getIndexer("POEM"));		
	}
	
	public Poem addBibItemToPoem(int poemId, int bibItemId) throws Exception {

		Poem poem = poemRepository.findById(poemId).map(foundPoem -> {
			BibItem bibItem;
				try {
					bibItem = bibItemRepository.findById(bibItemId).
						orElseThrow(() -> new Exception("Did not find bibitem with id " + bibItemId));
					foundPoem.addBibItem(bibItem);
					poemRepository.save(foundPoem);
					return foundPoem;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return foundPoem;
		}
			

		).orElseThrow(() -> new Exception("Did not find poem with id " + poemId));
		return poem;
	}
	
}
