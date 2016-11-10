package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

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
	private ArrayList<Product> products = null;
	private Pagination pagination;
	
	private String searchTerms = "";
	private Integer lowcap = 0;
	private Integer highcap = 9999;
	private String priceFilter = "any";
	private String typeFilter = "any";
	
	
	
	
	
	public String getTypeFilter() {
		return typeFilter;
	}
	public void setTypeFilter(String s) {
		typeFilter = s;
	}
	
	public String getPriceFilter() {
		return priceFilter;
	}
	public void setPriceFilter(String s) {
		priceFilter = s;
	}
	
	public Integer getHighcap() {
		return highcap;
	}
	public void setHighcap(Integer s) {
		try {
			highcap = s;
		}catch (Exception e){
			highcap = 9999;
		}
	}
	
	public Integer getLowcap() {
		return lowcap;
	}
	public void setLowcap(Integer s) {
		try {
			lowcap = s;
		}catch (Exception e){
			lowcap = 0;
		}
	}
	
	public String getSearchTerms() {
		return searchTerms;
	}
	public void setSearchTerms(String s) {
		searchTerms = s;
	}
	
	public float calculateStockLevel(Integer id) {
		return productService.calculatePercentageStock(id);
	}
	
	public void updateProduct(Integer id) {
		List<String> listParameters = new ArrayList<>();
		FacesContext.getCurrentInstance().getExternalContext().getRequestParameterNames().forEachRemaining(k->{
			listParameters.add(k);
			//System.out.println("PARAMETER: " + k);
		});
		String category = "";
		String active = "";
		for(String property : listParameters) {
			if(property.contains("details:j_idt38"))
				category = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(property);
			if(property.contains("details:j_idt41"))
				active = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(property);
		}
		String title = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_title");
		String price = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_price");
		String description = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_description");
		System.out.println("CATEGORY: " + category);
		String image = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_image");
		String tags = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_tags");
		String stock = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_stock");
		System.out.println(String.format("Product Updated- ID: %s | Title: %s | Price: £%s | Description: %s | Category: %s | Image: %s | Tags: %s | Stock: %s | Active: %s |", id, title, price, description, category.toString(), image, tags, stock, active.toString()));
		productService.updateProduct(id, title, price, description, category, image, tags, stock, active);
	}
	
	public String reset() {
		lowcap = 0;
		highcap = 9999;
		priceFilter = "any";
		typeFilter = "any";
		searchTerms = "";
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

	public ArrayList<Product> filterResults() {
		ArrayList<Product> initial = getProducts();
		ArrayList<Product> result = new ArrayList<Product>();
		
		List<String> listParameters = new ArrayList<>();
		FacesContext.getCurrentInstance().getExternalContext().getRequestParameterNames().forEachRemaining(k->{
			listParameters.add(k);
			//System.out.println("PARAMETER: " + k);
		});
		
		//Apply filter variables
		for(String property : listParameters) {
			if(property.contains("filter:j_idt17"))
				lowcap = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(property));
			if(property.contains("filter:j_idt18"))
				highcap = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(property));
			if(property.contains("filter:j_idt20"))
				priceFilter = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(property);
			if(property.contains("filter:j_idt25"))
				typeFilter = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(property);
			if(property.contains("filter_search"))
				searchTerms = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(property);
		}
		if (lowcap==null) lowcap=0;
		if (highcap==null) highcap=9999;

		//Limit by id range
		ArrayList<Product> idrange = new ArrayList<Product>();
		for (Product p : initial) {
			if (p.getProductId() > lowcap -1 && p.getProductId() <= highcap) {
				idrange.add(p);
			}
		}
		
		ArrayList<Product> cat = new ArrayList<Product>();
		//convert category string to enum

		for (Product p : idrange) {
			
			switch (typeFilter) {
			case "any":
				cat.add(p);
				break;
			case "gnome":
				if (p.getCategory().toString().equals(typeFilter.toUpperCase())) {
					cat.add(p);
				}
				break;
			case "gnomeaccessory":
				if (p.getCategory().toString().equals(typeFilter.toUpperCase())) {
					cat.add(p);
				}
				break;
			case "gardenfountain":
				if (p.getCategory().toString().equals(typeFilter.toUpperCase())) {
					cat.add(p);
				}
				break;
			}
		}
		System.out.println(searchTerms);
		if (searchTerms == null || searchTerms.isEmpty()) {
			System.out.println("skipped as no search terms present, itemsize: " + cat.size());
			result = cat;
		} else {
			
			
			for (Product p : cat) {
				//System.out.println(p.getTitle());
				if (matchSearchTerms(p)) {
					result.add(p);
				}
			}
		}
				
		
		//Sorting
		switch (priceFilter) {
		case "any":
			break;
		case "hightolow":
			result.sort((o1, o2) -> o1.getProductId().compareTo(o2.getProductId()));
			Collections.reverse(cat);
			break;
		case "lowtohigh":
			result.sort((o1, o2) -> o1.getProductId().compareTo(o2.getProductId()));
			break;
		}
		return result;
	}
	
	
	public Boolean matchSearchTerms(Product p) {
		String[] terms = searchTerms.split(",");
		String[] title = p.getTitle().split(" ");
		
		
		for (String s : title) {
			for (String str : terms) {
				if (s.trim().toLowerCase().equals(str.trim().toLowerCase())) {
					return true;
				}
			}
		}
		
		String[] pTerms = p.getTags().split(",");
		for (String str : pTerms) {
			for (String s : terms) {
				if (s.trim().toLowerCase().equals(str.trim().toLowerCase())) {
					//Tag has matched add to list
					return true;
				}
			}
		}
		return false;
	}
	
	public ArrayList<Product> getProducts() {
		if(products == null) {
			return new ArrayList<Product>(productService.findAll());
		}
			//products = getPagination().createArrayList();
		
		//String order = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("filter_order");
		//String type = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("filter_type");
		//String search = "";
		//try {
		//search = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("filter_search");
		//System.out.println(order + " : " + type + " : " + search);
		//System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap());
		//} catch (Exception e){
			
		//}
		//List<Product> list = new ArrayList<Product>();
		//for (Product p : products) {
		//	if (search != null) {
				//Search matching
		//		if (p.getTitle().contains(search)) {
		//			list.add(p);
		//			System.out.println(p.getTitle());
		//		}
		//	}
		//}
		//DataModel<Product> rtn = (DataModel<Product>) list;
		
		return products;
	}

	private Pagination getPagination() {
		if(pagination==null)
			pagination = new Pagination(20) {
				
				@Override
				public ArrayList<Product> createArrayList() {
					try {
						return new ArrayList<Product>(productService.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ArrayList<Product>(productService.findAll().subList(getPageFirstItem(), getItemsCount()));
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

