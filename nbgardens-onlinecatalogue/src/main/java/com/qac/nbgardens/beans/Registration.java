package com.qac.nbgardens.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.qac.nbgardens.entities.Customer;

@Named("newUser")
@SessionScoped
public class Registration implements Serializable {
	private Customer user;
	
	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}
}