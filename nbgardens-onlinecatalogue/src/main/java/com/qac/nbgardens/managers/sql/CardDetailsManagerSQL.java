package com.qac.nbgardens.managers.sql;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.managers.CardDetailsManager;

@Alternative
@Stateless
public class CardDetailsManagerSQL implements CardDetailsManager{

	@Override
	public void updateCardDetails(Integer UserId, String cardNo, String cardExpiry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CardDetails findByCardNo(String Card_No) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardDetails findCardByUserId(Integer UserId) {
		// TODO Auto-generated method stub
		return null;
	}

}
