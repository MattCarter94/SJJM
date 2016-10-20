package com.nbgardens.net_app.managers;
import java.util.ArrayList;
import java.util.List;

import com.nbgardens.net_app.entities.CardDetails;


public interface CardDetailsManager {
	
	public void persistCardDetails (CardDetails a);
	public void persistCardDetails(List<CardDetails> a);
	
	public CardDetails findById(String Card_Id);
	
	public ArrayList<CardDetails> getCardDetails();
	
	public void updateCardDetails (CardDetails a);
	public void removeCardDetails (CardDetails a);

}
