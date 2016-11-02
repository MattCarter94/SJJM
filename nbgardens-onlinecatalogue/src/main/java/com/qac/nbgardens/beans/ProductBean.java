package com.qac.nbgardens.beans;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="prodbean")
@SessionScoped
public class ProductBean {

		public int id;
		public static String title;
		
		//Constructor
		public ProductBean() {
			
		}

		
		//get value from f:param
//		public int getIdParam(FacesContext fc){
//
//			Map<int,int> params = fc.getExternalContext().getRequestParameterMap();
//			return params.get("country");
//
//		}
//		
		
		//Getters and Setters
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}
		
		
}
