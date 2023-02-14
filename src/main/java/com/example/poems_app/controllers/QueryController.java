package com.example.poems_app.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.poems_app.BibItem;
import com.example.poems_app.BibItemSource;
import com.example.poems_app.ImportService;
import com.example.poems_app.QueryForm;
import com.example.poems_app.factories.AbstractQueryFactory;
import com.example.poems_app.factories.QueryFactoryInterface;
import com.example.poems_app.queryExecutors.BibItemQueryExecutor;
import com.example.poems_app.queryModules.QueryModule;
import com.example.poems_app.searchinterfaces.SearchInterfaces;
import com.example.poems_app.services.Importer;

@RestController
public class QueryController {

	@Autowired
	private ImportService importService;

	@CrossOrigin
	@GetMapping("/searchInterfaceTypes") 
	public Iterable<String> getInterfaces() {
		return Arrays.asList(SearchInterfaces.values()).
		stream().map(val -> val.toString()).collect(Collectors.toList());
	}
	
	@CrossOrigin
	@GetMapping("/bibItemSources")
	public Iterable<BibItemSource> getBibtemSources() {
		return importService.findAllBibItemSources();
	}

	@CrossOrigin
	@GetMapping("/bibItemSources/{id}")
	public Optional<BibItemSource> getBibItemSource(@PathVariable int id) {
		return importService.findBibItemSourceById(id);
	}

	@CrossOrigin
	@PostMapping("/bibItemSources")
	public BibItemSource getBibItemSource(@RequestBody BibItemSource bibItemSource) {
		return importService.saveBibItemSource(bibItemSource);
	}

	@CrossOrigin
	@DeleteMapping("/bibItemSources/{id}")
	public void deleteBibItemSource(@PathVariable int id) {
		importService.deleteBibItemSourceById(id);
	}

	@CrossOrigin
	@PutMapping("/bibItemSources/{id}")
	public void updateBibItemSource(@PathVariable int id, @RequestBody BibItemSource bibItemSource) {
		if (id > 0) {
			bibItemSource.setId(id);
			importService.updateBibItemSource(bibItemSource);
		}
	}

	@CrossOrigin
	@GetMapping("/getResultsFromBibItemSourceQuery")
	public Iterable<BibItem> getResultsFromBibItemSourceQueryWithNrRecords(@RequestParam String id,
			@RequestParam String query, @RequestParam(defaultValue = "10") int nrRecords) throws IOException {
		Optional<BibItemSource> bibItemSource = getBibItemSource(Integer.valueOf(id));
		BibItemSource bibSource = bibItemSource.get();

		return importService.getBibItems(bibSource, query, nrRecords);
	}

	@CrossOrigin
	@GetMapping("/getResultsFromQuery")
	public Iterable<BibItem> getResultsFromQuery(@RequestBody QueryForm queryForm) throws IOException {
		QueryFactoryInterface queryFactory = AbstractQueryFactory.getFactory(queryForm.getQueryType());
		QueryModule queryMod = null;
		BibItemQueryExecutor queryExecutor = null;
		if (queryFactory != null) {
			queryMod = queryFactory.getQueryModuler();
			queryMod.setFormat(queryForm.getFormat());

			System.out.println(queryForm.getFormat());
			queryExecutor = queryFactory.getQueryExecutor();
		}

		Importer importer = new Importer(queryMod, queryExecutor);
		return importer.importItems(queryForm.getQueryValue());
	}
}
