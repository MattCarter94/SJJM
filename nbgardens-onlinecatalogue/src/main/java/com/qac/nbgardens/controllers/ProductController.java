package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.beans.ProductBean;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.enums.Category;
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
	private Category category = Category.ALL;
	private List<Category> categories = Arrays.asList(Category.GNOME, Category.GNOMEACCESSORY, Category.GARDENFOUNTIAN, Category.ALL);
	private String search = "";
	private int sort = 0;
	
	private List<Double> lowRange;
	private List<Double> highRange;
	
	private DecimalFormat df = new DecimalFormat("#.00"); 
	
	
	
	
	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

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

//	public String next() {
//		getPagination().nextPage();
//		recreateModel();
//		return "products";
//	}
//	
//	public String previous() {
//		getPagination().previousPage();
//		recreateModel();
//		return "products";	
//	}
	
	public void recreateModel() {
		products = null;
	}
	
	public ArrayList<Product> getProductsSearch(){
		products = productService.findAll(search);//getPagination().niceDataModel();//getPagination().createDataModel();
		return products;
	}

	public ArrayList<Product> getProducts() {
//		System.out.println("get products");
//		if(products == null)
		products = productService.findAll(priceLow, priceHigh, category, search);//getPagination().niceDataModel();//getPagination().createDataModel();
//		System.out.println(products.size());
		
		// if sorting
		if(sort==0){
			return products;
		}
		
		if(sort==1){
			Collections.sort(products, (o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
		}
		
		if(sort==2){
			Collections.sort(products, (o1, o2) -> (int) (o2.getPrice() - o1.getPrice()));
		}
		
		return products;
	}
	

//	public Pagination getPagination() {
//		if(pagination==null)
//			pagination = new Pagination(4) {
//				
//				@Override
//				public DataModel<Product> createDataModel() {
//					try {
//						return new ListDataModel<Product>(productService.findAll(priceLow, priceHigh).subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
//					} catch (Exception e) {
//						return new ListDataModel<Product>(productService.findAll(priceLow, priceHigh).subList(getPageFirstItem(), getItemsCount()));
//					}
//				}
//
//				@Override
//				public int getItemsCount() {
//					System.out.println("Item Count " + productService.findAll(priceLow, priceHigh).size());
//					return productService.findAll(priceLow, priceHigh).size();
//				}
//
//				@Override
//				public DataModel<Product> createDataModel(double low, double high) {
//					try {
//						return new ListDataModel<Product>(productService.findAll(priceLow, priceHigh).subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
//					} catch (Exception e) {
//						return new ListDataModel<Product>(productService.findAll(priceLow, priceHigh).subList(getPageFirstItem(), getItemsCount()));
//					}
//				}
//				
//				@Override
//				public DataModel<Product> niceDataModel() {
//					return new ListDataModel<Product>(productService.findAll(priceLow, priceHigh));
//				}
//				
//			};
//		return pagination;
//	}
	
	
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

