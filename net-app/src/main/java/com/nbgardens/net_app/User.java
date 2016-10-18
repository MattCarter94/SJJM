package com.nbgardens.net_app;

import java.util.Currency;

public class User {
	
	private enum Permissions{
		Customer, Admin, IMS
	};
	
	private Integer userID;
	private String firstName;
	private String surname;
	private Currency credit;
	private String email;
	private String phoneNo;
	private String password;
	private Permissions permissions;
	private String address1;
	private String address2;
	private String town;
	private String county;
	private String postcode;
}
