package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.service.ProductService;
import com.qac.nbgardens.util.Pagination;


@Named("search")
@RequestScoped
public class SearchController implements Serializable{
	@Inject
	private ProductService productService;
	
	List<Product> products;
	private String searchTerms;
	
	public String getSearchTerms() {
		return searchTerms;
	}
	
	public void setSearchTerms(String s) {
		searchTerms = s;
	}
	
	public List<Product> FilterResults() {
		products = productService.findAll();
		
		return products;
//		if (searchTerms == null || searchTerms == "") {
//			System.out.println("No search terms");
//			return products;
//		}
//		
//		List<Product> filtered = new ArrayList<Product>();
//		
//		System.out.println(searchTerms);
//		for (Product pdt : products) {
//			
//			if (pdt.getTitle().contains(searchTerms)) {
//				System.out.println(pdt.getTitle());
//				//Product matches search term add to list
//				filtered.add(pdt);
//			}
//		}
//		return filtered;
	}
}

