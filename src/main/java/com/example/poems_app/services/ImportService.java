package com.example.poems_app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.poems_app.BibItem;
import com.example.poems_app.BibItemSource;
import com.example.poems_app.factories.QueryInterfaceFactory;
import com.example.poems_app.queryInterfaces.QueryInterface;

@Service
public class ImportService {

	public List<BibItem> getBibItems (BibItemSource bibItemSource, String query) {
		
		String interfaceType = bibItemSource.getInterfaceType();
		QueryInterface queryInterface = QueryInterfaceFactory.getQueryInterface(interfaceType);
		return queryInterface.performQuery(bibItemSource.getHost(), query);
	}

}
