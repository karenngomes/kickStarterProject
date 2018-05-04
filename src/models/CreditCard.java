package models;

public class CreditCard {
	private Integer numberCard;
	private Integer password;
	private String holderName;
	private Integer expiredMonth;
	private Integer expiredYear;


	public CreditCard(Integer numberCard, Integer password, String holderName,
			Integer expiredMonth, Integer expiredYear) {
		this.numberCard = numberCard;
		this.password = password;
		this.holderName = holderName;
		this.expiredMonth = expiredMonth;
		this.expiredYear = expiredYear;
	}

	public Integer getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(Integer numberCard) {
		this.numberCard = numberCard;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Integer getExpiredMonth() {
		return expiredMonth;
	}

	public void setExpiredMonth(Integer expiredMonth) {
		this.expiredMonth = expiredMonth;
	}

	public Integer getExpiredYear() {
		return expiredYear;
	}

	public void setExpiredYear(Integer expiredYear) {
		this.expiredYear = expiredYear;
	}
	
}
