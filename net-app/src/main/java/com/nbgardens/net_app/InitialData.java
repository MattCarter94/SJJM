package com.nbgardens.net_app;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;



@Startup
@Singleton
public class InitialData {
	private List<User> users = new ArrayList<User>();
	
	@PostConstruct
	public void SetupData() {
		users.add(
			new User("Matt", "Carter", "matt@email.co.uk", "02938475812", "password1", 2, "420", "Blaze Rd", "Cranberry", "Oxfordshire", "OX123AB")
			
		);
	}
}
