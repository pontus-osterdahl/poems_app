package com.example.poems_app.factories;

import com.example.poems_app.queryInterfaces.QueryInterface;
import com.example.poems_app.queryModules.XsearchInterface;

public class QueryInterfaceFactory {
	static public QueryInterface getQueryInterface(String interfaceType) {
        QueryInterface queryInterface = null;
        if (interfaceType.equals("Xsearch")) {
        	queryInterface = new XsearchInterface(); 
        }
        return queryInterface;
    }
    
}
