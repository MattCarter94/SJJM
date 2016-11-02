package com.qac.nbgardens.beans;
import javax.faces.bean.*;

@Deprecated
@ManagedBean(name="customers")
public class Customers {
	
	private String username;
	private String password;
	
	@Deprecated
	public Customers (){
		
	}

	@Deprecated
	public String getUsername() {
		return username;
	}

	@Deprecated
	public void setUsername(String username) {
		this.username = username;
	}

	@Deprecated
	public String getPassword() {
		return password;
	}

	@Deprecated
	public void setPassword(String password) {
		this.password = password;
	}
}
