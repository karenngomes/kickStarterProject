package models.projects;

import models.Category;
import models.Project;
import models.User;

public class Closed extends Project{

	public Closed(User owner, Category category, String name,
			String description, Integer durationDays, Double goalMoney) {
		super(owner, category, name, description, durationDays, goalMoney);
		// TODO Auto-generated constructor stub
	}
	
	public Closed(Project project) {
		super(project.getOwner(),project.getCategory(),project.getName(),project.getDescription(),project.getDurationDays(),project.getGoalMoney());
		this.setCurrentMoney(project.getCurrentMoney());
		this.setInitDay(project.getInitDay());
		this.setListComments(project.getListComments());
		this.setListContributors(project.getListContributors());
		this.setListRewards(project.getListRewards());
	}

}
