package models;

import java.util.ArrayList;

public class Reward {
	private String name;
	private String description;
	private ArrayList<String> listIncludes;
	private ArrayList<User> listCollaborators;
	private Double price;

	public Reward(String name, String description, Double price, ArrayList<String> listIncludes) {
		this.name = name;
		this.description = description;
		this.listIncludes = listIncludes;
		this.listCollaborators = new ArrayList<User>();
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<String> getListIncludes() {
		return listIncludes;
	}

	public void setListIncludes(ArrayList<String> listIncludes) {
		this.listIncludes = listIncludes;
	}

	public ArrayList<User> getListCollaborators() {
		return listCollaborators;
	}

	public void setListCollaborators(ArrayList<User> listCollaborators) {
		this.listCollaborators = listCollaborators;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
