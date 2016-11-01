package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.beans.ProductBean;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.service.ProductService;
import com.qac.nbgardens.util.Pagination;


@Named("products")
@SessionScoped
public class ProductController implements Serializable{
	@Inject
	private ProductService productService;
	private DataModel<Product> products = null;
	private Pagination pagination;
	
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "products";
	}
	
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "products";	
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
						return new ListDataModel<Product>(productService.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(productService.findAll().subList(getPageFirstItem(), getItemsCount()));
					}
				}

				@Override
				public int getItemsCount() {
					return productService.findAll().size();
				}
			};
		return pagination;
	}
	
	
//	public Product findProductById(Integer id) {
//		DataModel<Product> dm = getProducts();
//		Product p = dm.getRowData();
//		
//		return p;
//		
////		for (int i = 0; i < products.size(); i++) {
////			if (products.get(i).getProductID().equals(id)) {
////				return products.get(i);
////			}
////		}
////		return null;
//	}
	

	
}

