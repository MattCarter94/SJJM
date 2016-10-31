package com.qac.nbgardens.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.managers.ProductManager;
import com.qac.nbgardens.service.BrowseService;
import com.qac.nbgardens.util.Pagination;

@Named("browse")
@SessionScoped
public class BrowseController implements Serializable{
	@Inject
	private BrowseService browseService;
	private DataModel<Product> products = null;
	private Pagination pagination;
	
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "browse";
	}
	
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "browse";	
	}
	
	private void recreateModel() {
		products = null;
	}

	public DataModel<Product> getProducts() {
		if(products == null)
			products = getPagination().createDataModel();
		return products;
	}

	private Pagination getPagination() {
		if(pagination==null)
			pagination = new Pagination(20) {
				
				@Override
				public DataModel createDataModel() {
					try {
						return new ListDataModel<Product>(browseService.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(browseService.findAll().subList(getPageFirstItem(), getItemsCount()));
					}
				}

				@Override
				public int getItemsCount() {
					return browseService.findAll().size();
				}
			};
		return pagination;
	}
}