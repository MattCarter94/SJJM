package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.ArrayList;
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
	private ArrayList<Product> products = null;
	private Pagination pagination;
	private int selected;
	private Product product;
	private double priceLow = 0;;
	private double priceHigh = 320;
	private List<Double> range = null;
	private List<Double> lowRange;
	private List<Double> highRange;
	
	
	
	
	public List<Double> getRange() {
		return productService.priceRange();
	}

	public void setRange(List<Double> range) {
		this.range = range;
	}

	public double getPriceLow() {
		return priceLow;
	}

	public void setPriceLow(double priceLow) {
		this.priceLow = priceLow;
	}

	public double getPriceHigh() {
		return priceHigh;
	}

	public void setPriceHigh(double priceHigh) {
		this.priceHigh = priceHigh;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

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

	public ArrayList<Product> getProducts() {
//		System.out.println("get products");
//		if(products == null)
			products = productService.findAll(priceLow, priceHigh);//getPagination().niceDataModel();//getPagination().createDataModel();
//		System.out.println(products.size());
		return products;
	}
	

	public Pagination getPagination() {
		if(pagination==null)
			pagination = new Pagination(4) {
				
				@Override
				public DataModel<Product> createDataModel() {
					try {
//						products = new ListDataModel<Product>(productService.findAll(priceLow, priceHigh).subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
						return new ListDataModel<Product>(productService.findAll(priceLow, priceHigh).subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
//						products = new ListDataModel<Product>(productService.findAll(priceLow, priceHigh).subList(getPageFirstItem(), getItemsCount()));
						return new ListDataModel<Product>(productService.findAll(priceLow, priceHigh).subList(getPageFirstItem(), getItemsCount()));
					}
				}

				@Override
				public int getItemsCount() {
					System.out.println("Item Count " + productService.findAll(priceLow, priceHigh).size());
					return productService.findAll(priceLow, priceHigh).size();
				}

				@Override
				public DataModel<Product> createDataModel(double low, double high) {
					try {
						return new ListDataModel<Product>(productService.findAll(priceLow, priceHigh).subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(productService.findAll(priceLow, priceHigh).subList(getPageFirstItem(), getItemsCount()));
					}
				}
				
				@Override
				public DataModel<Product> niceDataModel() {
					return new ListDataModel<Product>(productService.findAll(priceLow, priceHigh));
				}
				
			};
		return pagination;
	}
	
	
	public Product findProductById(Integer id) {
		return productService.findProductById(id);
	}

	
	
	
	
//	public List<Product> getDataModel() {
//		  if (products == null)
//		    products = getPagination().createDataModel();
//		  return products;
//		}

//	private void updateCurrentItem() {
//		  int count = productService.findAll().size();
//		  if (selected >= count) {
//		    selected = count-1;
//		    if (pagination.getPageFirstItem() >= count)
//		      pagination.previousPage();
//		  } if (selected >= 0)
//		    try {
//		      setProduct(productService.findAll().subList(selected, selected + 1).get(0));
//		    } catch(Exception e) {
//		      setProduct(productService.findAll().subList(selected, count).get(0));
//		   }
//		}

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

