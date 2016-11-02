package com.qac.nbgardens.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.beans.UserCredentials;
import com.qac.nbgardens.service.LoginService;

@Named(value = "login")
@RequestScoped
public class LoginController {
	@Inject
	LoginService loginService;
	@Inject
	UserCredentials userCredentials;
	private String email = "";
	private String password = "";
	private String error = "";

	public String login() {
		if (email.equals("")) {
			error = "please enter your email";
			password = "";
			return "login";
		}
		if (password.equals("")) {
			error = "please enter a password";
			password = "";
			return "login";
		}
		if (!loginService.validateDetails(email, password)) {
			error = "Invalid login";
			password = "";
			return "login";
		}

		userCredentials.setUser(loginService.getUserID(email));

		return "index";
	}

	public String logout() {
		userCredentials.setUser(null);
		return "home";
	}

	public String getUsername() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getError() {
		return error;
	}

	public void setUsername(String user) {
		this.email = user;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}
}