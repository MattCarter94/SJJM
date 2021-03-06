package com.qac.nbgardens.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.beans.UserCredentials;
import com.qac.nbgardens.service.LoginService;


@Named("login")
@RequestScoped
public class LoginController {
	@Inject
	private LoginService loginService;
	@Inject
	private UserCredentials userCredentials;
	@Inject
	private BasketController basketController;
	
	private String email = "";
	private String password = "";
	private String error = "";
	private boolean failedLogin = false;

	public String login() {
		if (email.equals("")) {
			error = "please enter your email";
			password = "";
			failedLogin = true;
			return "login";
		}
		if (password.equals("")) {
			error = "please enter a password";
			password = "";
			failedLogin = true;
			return "login";
		}
		if (!loginService.validateDetails(email, password)) {
			error = "Invalid login";
			password = "";
			System.out.println("invalid Login");
			failedLogin = true;
			return "login";
		}

		userCredentials.setUser(loginService.getUserID(email));
		failedLogin = false;
		System.out.println("Valid login");
		userCredentials.setBasket(loginService.getBasket(email));
//		basketController.setBasket(userCredentials.getUser().getEmail());
		return "index";
	}

	public String logout() {
		userCredentials.setUser(null);
		return "home";
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getError() {
		return error;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public boolean isFailedLogin() {
		return failedLogin;
	}

	public void setFailedLogin(boolean failedLogin) {
		this.failedLogin = failedLogin;
	}
	
	public boolean getFailedLogin() {
		return failedLogin;
	}
}