package com.qac.nbgardens.managers.sql;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.managers.UserManager;

@Alternative
@Stateless
public class UserManagerSQL implements UserManager{

	@Override
	public void persistUser(CardDetails card, String name, String surname, String email, String phoneNo,
			String password, Integer permissions, String add1, String add2, String town, String county,
			String postcode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserEmail(Integer id, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserPhoneNo(Integer id, String phoneNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserPassword(Integer id, String password) {
		// TODO Auto-generated method stub
		
	}

}
