package com.qac.nbgardens.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.qac.nbgardens.entities.Customer;

@Named("registration")
@RequestScoped
public class Registration implements Serializable {
	private Customer user;
	
	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}
}