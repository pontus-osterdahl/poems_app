package com.example.poems_app.factories;

import com.example.poems_app.queryExecutors.BibItemQueryExecutor;
import com.example.poems_app.queryExecutors.LibrisQueryExecutor;
import com.example.poems_app.queryModules.LibrisQueryModule;
import com.example.poems_app.queryModules.QueryModule;

public class LibrisQueryFactory implements QueryFactoryInterface {

	@Override
	public QueryModule getQueryModuler() {
		return new LibrisQueryModule();
	}

	@Override
	public BibItemQueryExecutor getQueryExecutor() {
		return new LibrisQueryExecutor();
	}

}
