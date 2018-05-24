package models;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Project {
	private User owner;
	private Category category;
	private String name;
	private String description;
	private Calendar initDay;
	private Integer durationDays;
	private Double currentMoney;
	private Double goalMoney;
	private ArrayList<User> listContributors;
	private ArrayList<Reward> listRewards;
	private ArrayList<Comment> listComments;
	
	public Project(User owner, Category category, String name, String description,
			Integer durationDays, Double goalMoney) {
		this.owner = owner;
		this.category = category;
		this.name = name;
		this.description = description;
		this.durationDays = durationDays;
		this.goalMoney = goalMoney;
		this.listComments = new ArrayList<Comment>();
		this.listRewards = new ArrayList<Reward>();
		this.listContributors = new ArrayList<User>();
		this.currentMoney = 0.0;
		this.initDay = Calendar.getInstance();
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public Calendar getInitDay() {
		return initDay;
	}

	public void setInitDay(Calendar initDay) {
		this.initDay = initDay;
	}

	public Integer getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(Integer durationDays) {
		this.durationDays = durationDays;
	}

	public Double getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(Double currentMoney) {
		this.currentMoney = currentMoney;
	}

	public Double getGoalMoney() {
		return goalMoney;
	}

	public void setGoalMoney(Double goalMoney) {
		this.goalMoney = goalMoney;
	}

	public ArrayList<User> getListContributors() {
		return listContributors;
	}

	public void setListContributors(ArrayList<User> listContributors) {
		this.listContributors = listContributors;
	}

	public ArrayList<Reward> getListRewards() {
		return listRewards;
	}

	public void setListRewards(ArrayList<Reward> listRewards) {
		this.listRewards = listRewards;
	}

	public ArrayList<Comment> getListComments() {
		return listComments;
	}

	public void setListComments(ArrayList<Comment> listComments) {
		this.listComments = listComments;
	}
	
}
