package com.qac.nbgardens.managers;
import java.util.ArrayList;
import java.util.List;

import com.qac.nbgardens.entities.CardDetails;

public interface CardDetailsManager {
	
	public CardDetails findByCardNo(String Card_No);
	
	public CardDetails findCardByUserId(Integer UserId);
	

}
