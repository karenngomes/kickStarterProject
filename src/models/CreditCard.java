package models;

import java.util.Calendar;

public class CreditCard {
	private Integer id;
	private Integer numberCard;
	private String holderName;
	private Calendar expiredDate;
	
	public CreditCard() {

	}

	public CreditCard(Integer id, Integer numberCard, String holderName,
			Calendar expiredDate) {
		super();
		this.id = id;
		this.numberCard = numberCard;
		this.holderName = holderName;
		this.expiredDate = expiredDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(Integer numberCard) {
		this.numberCard = numberCard;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Calendar getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Calendar expiredDate) {
		this.expiredDate = expiredDate;
	}

	
	
	
}
