package models;

import java.util.ArrayList;

public class Reward {
	private Integer id;
	private String name;
	private String description;
	private ArrayList<String> listIncludes;
	private ArrayList<User> listCollaborators;
	private Double price;
	
	public Reward() {
		this.listIncludes = new ArrayList<String>();
		this.listCollaborators = new ArrayList<User>();
	}

	public Reward(Integer id, String name, String description, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.listIncludes = new ArrayList<String>();
		this.listCollaborators = new ArrayList<User>();
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
