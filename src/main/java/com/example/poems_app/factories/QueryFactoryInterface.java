package com.example.poems_app.factories;

import com.example.poems_app.queryExecutors.BibItemQueryExecutor;
import com.example.poems_app.queryModules.QueryModule;

public interface QueryFactoryInterface {

  	public QueryModule getQueryModuler();
  	public BibItemQueryExecutor getQueryExecutor();
	
}
