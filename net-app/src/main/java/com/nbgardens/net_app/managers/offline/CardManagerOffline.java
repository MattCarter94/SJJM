package com.nbgardens.net_app.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import com.nbgardens.net_app.entities.CardDetails;
import com.nbgardens.net_app.managers.CardDetailsManager;


public class CardManagerOffline  implements CardDetailsManager {
	
	@Inject
	
	public void persistCardDetails (CardDetails a) {
		
	}
	
	@Override
	public void persistCardDetails(List<CardDetails> a) {
		
	}
	
	
	@Override
	public ArrayList<CardDetails> getCardDetails() {
		return getCardDetails();
	}
	
	@Override
	public void updateCardDetails (CardDetails a) {
		
	}
	
	@Override
	public void removeCardDetails (CardDetails a) {
		
	}

	@Override
	public CardDetails findById(CardDetails Card_Id) {
		return Card_Id;
	}
	

}

