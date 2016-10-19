package com.nbgardens.net_app;
import java.util.ArrayList;
import java.util.List;


public interface CardDetailsManager {
	
	public void persistCardDetails (CardDetails a);
	public void persistCardDetails(List<CardDetails> a);
	
	public CardDetails findById(String Card_Id);
	
	public ArrayList<CardDetails> getCardDetails();
	
	public void updateCardDetails (CardDetails a);
	public void removeCardDetails (CardDetails a);

}
