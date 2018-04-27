package models.projects;

import models.Category;
import models.Project;
import models.User;

public class Closed extends Project{

	public Closed(Integer id, User owner, Category category, String name,
			String description, Integer durationDays, Double goalMoney) {
		super(id, owner, category, name, description, durationDays, goalMoney);
		// TODO Auto-generated constructor stub
	}

}
