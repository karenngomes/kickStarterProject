package models;

import java.util.ArrayList;

public class Profile {
	private String biography;
	private String location;
	private ArrayList<User> listFollowers;
	
	public Profile() {
		this.listFollowers = new ArrayList<User>();
	}

	public Profile(String biography, String location) {
		this.biography = biography;
		this.location = location;
		this.listFollowers = new ArrayList<User>();
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<User> getListFollowers() {
		return listFollowers;
	}

	public void setListFollowers(ArrayList<User> listFollowers) {
		this.listFollowers = listFollowers;
	}
	
	

}
