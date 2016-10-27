package com.qac.nbgardens.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.entities.User;
import com.qac.nbgardens.managers.CardDetailsManager;
import com.qac.nbgardens.util.InitialData;


public class CardDetailsManagerOffline  implements CardDetailsManager {
	
	@Inject
	private InitialData initialData; 
	
	public void updateCardDetails (Integer UserId, String cardNo, String cardExpiry) {
		CardDetails card;
		int count = 0;
		List<User> us = initialData.getUsers();
		for(int i=0; i<us.size(); i++){
			if(us.get(i).getUserID().equals(UserId)){
				card = us.get(i).getCard();
				card.setCardNo(cardNo);
				card.setCardExpiry(cardExpiry);
				count++;
			}
		}
		if(count == 0){
			System.out.println("No users found with that ID");
		}
	}
	


	@Override
	public CardDetails findByCardNo(String Card_No) { //Define an override for findById (The method being overriden is in CardDetailsManager)
		//Passing in the variable "Card_No" (The primary key for the Card_Details table)
		CardDetails card; //Create a variable called 'card' of type CardDetails
		List<User> us = initialData.getUsers(); //Create new list of type "User" and assign the list of users from the InitialData file to it
			for(int i=0; i<us.size(); i++){ //For loop to loop through entire list of cards
				card = us.get(i).getCard(); //Assign value of the card associated with the user currently equal to i
				if(card.getCardNo().equals(Card_No)){ //If the card that the for loop matches the search query, return that card's details
					return card;
				}
			}
			return null; //If the loop found nothing, return null
	}
	
	@Override
	public CardDetails findCardByUserId(Integer UserId) {
		CardDetails userCard; 
		List<User> us = initialData.getUsers(); 
			for(int i=0; i<us.size(); i++){ 
				userCard = us.get(i).getCard(); 
				if(userCard.getCardNo().equals(UserId)){ 
					return userCard;
				}
			}
			return null;
	}
	

}
