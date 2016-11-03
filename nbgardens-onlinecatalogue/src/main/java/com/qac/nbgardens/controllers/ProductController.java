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
	private int selected;
	private Product product;
	
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
	
	public void recreateModel() {
		products = null;
	}

	public DataModel<Product> getProducts() {
		if(products == null)
			products = getPagination().createDataModel();
		return products;
	}

	public Pagination getPagination() {
		if(pagination==null)
			pagination = new Pagination(5) {
				
				@Override
				public DataModel<Product> createDataModel() {
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
	
	
	public Product findProductById(Integer id) {
		return productService.findProductById(id);
	}

	
	
	
	
	public DataModel<Product> getDataModel() {
		  if (products == null)
		    products = getPagination().createDataModel();
		  return products;
		}

	private void updateCurrentItem() {
		  int count = productService.findAll().size();
		  if (selected >= count) {
		    selected = count-1;
		    if (pagination.getPageFirstItem() >= count)
		      pagination.previousPage();
		  } if (selected >= 0)
		    try {
		      setProduct(productService.findAll().subList(selected, selected + 1).get(0));
		    } catch(Exception e) {
		      setProduct(productService.findAll().subList(selected, count).get(0));
		   }
		}

	public String view(Integer id) {
		  product = productService.findProductById(id);
		  return "product";
		}

		public Product getProduct() {
		  return product;
		}

		public void setProduct(Product product){
		  this.product = product;
		}

	
	
	
}

