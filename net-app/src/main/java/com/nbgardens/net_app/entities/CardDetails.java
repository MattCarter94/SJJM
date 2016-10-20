package com.nbgardens.net_app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "Card_Details")
public class CardDetails {
	
	@Id //ID is for PK
	@Column (name = "Card_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer cardID;
	
	@OneToOne //For FK.
	@JoinColumn(name="User_ID", nullable = false)
	@NotNull
	private User user;
	
	@Column (name = "Card_No", length = 19)
	@NotNull
	private String cardNo;
	
	@Column (name = "Card_Expiry")
	@NotNull
	private Date cardExpiry;
	
	
	//Constructor
	public CardDetails(){};
	public CardDetails(User userID, String cardNo, Date cardExpiry){
		this.user = userID;
		this.cardNo = cardNo;
		this.cardExpiry = cardExpiry;
	};
	
	
	
	//GETTERS AND SETTERS
	public Integer getCardID() {
		return cardID;
	}
	public void setCardID(Integer cardID) {
		this.cardID = cardID;
	}
	public User getUserID() {
		return user;
	}
	public void setUserID(User userID) {
		this.user = userID;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Date getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(Date cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	
}