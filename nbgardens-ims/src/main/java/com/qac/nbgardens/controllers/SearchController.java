package com.qac.nbgardens.controllers;

import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.qac.nbgardens.service.ProductService;
import com.qac.nbgardens.util.Pagination;


@Named("search")
@RequestScoped
public class SearchController implements Serializable{
	@Inject
	private ProductService productService;
	
	private String searchTerms;
	
	public String getSearchTerms() {
		return searchTerms;
	}
	
	public void setSearchTerms(String s) {
		searchTerms = s;
	}
}

