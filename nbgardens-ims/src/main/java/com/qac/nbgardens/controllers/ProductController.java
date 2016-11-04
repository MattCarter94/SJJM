package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.ProductStatus;
import com.qac.nbgardens.service.ProductService;
import com.qac.nbgardens.util.Pagination;


@Named("products")
@SessionScoped
public class ProductController implements Serializable{
	@Inject
	private ProductService productService;
	private DataModel<Product> products = null;
	private Pagination pagination;
	
	public float calculateStockLevel(Integer id) {
		return productService.calculatePercentageStock(id);
	}
	
	public void updateProduct(Integer id) {
		List<String> listParameters = new ArrayList<>();
		FacesContext.getCurrentInstance().getExternalContext().getRequestParameterNames().forEachRemaining(k->{
			listParameters.add(k);
		});
		String category = "";
		String active = "";
		for(String property : listParameters) {
			if(property.contains("j_idt32"))
				category = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(property);
			if(property.contains("j_idt36"))
				active = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(property);
		}
		String title = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_title");
		String price = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_price");
		String description = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_description");
		System.out.println("CATEGORY: " + category);
		String image = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_image");
		String tags = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_tags");
		String stock = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_stock");
		//System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap());
		
		System.out.println("ACTIVE: " + active);
		//System.out.println(active);
		for (String l : listParameters) {
			System.out.println("ListParam: " + l);
		}
		productService.updateProduct(id, title, price, description, category, image, tags, stock, active);
	}
	
	public String addProduct() {
		List<String> listParameters = new ArrayList<>();
		FacesContext.getCurrentInstance().getExternalContext().getRequestParameterNames().forEachRemaining(k->{
			listParameters.add(k);
		});
		String category = "";
		String active = "";
		for(String property : listParameters) {
			//System.out.println(property);
			if(property.contains("j_idt15"))
				category = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(property);
			if(property.contains("j_idt18"))
				active = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(property);
		}
		String title = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_title");
		String price = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_price");
		String description = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_description");
		System.out.println("CATEGORY: " + category);
		String image = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_image");
		String tags = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_tags");
		String stock = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_stock");
		//System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap());
		//System.out.println(title + ", " + price + ", " + description + ", " + category + ", " + image + ", " + tags + ", " + stock + ", " + active);
		productService.addProduct((int)(Math.random() * 1000), title, price, description, category, image, tags, stock, active, new Date());
		//productService.addProduct(105, title, price, description, category, image, tags, stock, active, new Date());
		return "products";
	}
	
	public SelectItem[] getActiveValues() {
		SelectItem[] items = new SelectItem[ProductStatus.values().length];
		int i = 0;
		for (ProductStatus ps : ProductStatus.values()) {
			items[i++] = new SelectItem(ps, ps.toString());
		}
		return items;
	}
	
	public SelectItem[] getCategoryValues() {
		SelectItem[] items = new SelectItem[Category.values().length];
		int i = 0;
		for (Category c : Category.values()) {
			items[i++] = new SelectItem(c, c.toString());
		}
		return items;
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
}

