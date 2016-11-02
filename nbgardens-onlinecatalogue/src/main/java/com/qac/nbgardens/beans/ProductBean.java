package com.qac.nbgardens.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="prodbean")
@SessionScoped
public class ProductBean {

		public int id;
		
		//Constructor
		public ProductBean() {
			
		}

	
		//Getters and Setters
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}


}
