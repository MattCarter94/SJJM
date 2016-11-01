package com.qac.nbgardens.beans;
import javax.faces.bean.*;

@ManagedBean(name="customers")
public class Customers {
	
	private String username;
	private String password;
	
	public Customers (){
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
