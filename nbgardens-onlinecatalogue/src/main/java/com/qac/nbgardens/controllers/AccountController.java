package com.qac.nbgardens.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.service.AccountService;

@Named("account")
@RequestScoped
public class AccountController {

	@Inject
	AccountService accountService;
	
	public boolean hasOrders(){
		System.out.println("controller hasOrders");
		boolean x = accountService.hasorders();
		return x;
	}
	
}
