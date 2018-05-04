package models;

import java.util.ArrayList;
import java.util.Map;

public class User {
	private String name;
	private String email;
	private String password;
	private ArrayList<CreditCard> listCreditCards;
	private Map<Project, Double> projectInvestments;
	private Map<Project, ArrayList<String>> projectIncludes;
	private Profile profile;
	private Double balanceAccount;
	
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.listCreditCards = new ArrayList<CreditCard>();
		this.profile = new Profile();
		this.balanceAccount = 0.0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<CreditCard> getListCreditCards() {
		return listCreditCards;
	}

	public void setListCreditCards(ArrayList<CreditCard> listCreditCards) {
		this.listCreditCards = listCreditCards;
	}

	public Map<Project, Double> getProjectInvestments() {
		return projectInvestments;
	}

	public void setProjectInvestments(Map<Project, Double> projectInvestments) {
		this.projectInvestments = projectInvestments;
	}
	
	public Map<Project, ArrayList<String>> getProjectIncludes() {
		return projectIncludes;
	}

	public void setProjectIncludes(Map<Project, ArrayList<String>> projectIncludes) {
		this.projectIncludes = projectIncludes;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Double getBalanceAccount() {
		return balanceAccount;
	}

	public void setBalanceAccount(Double balanceAccount) {
		this.balanceAccount = balanceAccount;
	}
	
	public void editProfile(Profile profile) {
		this.profile = profile;
	}
	
	public void addCreditCard(CreditCard creditCard) {
		try {
			listCreditCards.add(creditCard);
			System.out.println("Cartao de credito adicionado com sucesso!");
		} catch (NullPointerException err) {
			System.out.println("Nao foi possivel adicionar este cartao de credito");
			throw err;
		}
		
	}
	
	public boolean checkFollowing(String email) {
		for(User user: getProfile().getListFollowers()){
			if(user.getEmail().equals(email))
				return false;
		}
		
		return true;
	}
	
	public void addFollower(User user) {
		try{
			profile.getListFollowers().add(user);
		}catch(NullPointerException err){
			this.setProfile(new Profile());
		}
	}

	public boolean checkNumberCard(Integer number){
		for(CreditCard creditCard : listCreditCards) {
			if(creditCard.getNumberCard().equals(number)){
				return true;
			}
		}
		return false;
	}

}
