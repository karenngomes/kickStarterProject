package models.projects;

import java.util.ArrayList;

import models.Category;
import models.Comment;
import models.Project;
import models.Reward;
import models.User;

public class Progress extends Project{

	public Progress(Integer id, User owner, Category category, String name, String description,
			Integer durationDays, Double goalMoney) {
		super(id, owner, category, name, description, durationDays, goalMoney);
	}
	
	public void addContributor(User user, Double quantity) {
		ArrayList<String> listIncludesUser = new ArrayList<String>();
		
		getListContributors().add(user);
		
		try{
			user.getProjectInvestments().put(this, user.getProjectInvestments().get(this) + quantity);
		}catch(Exception err) {
			user.getProjectInvestments().put(this, quantity);
		}
		
		for(Reward reward : getListRewards()) {
			if(reward.getPrice() <= quantity) {
				listIncludesUser.addAll(reward.getListIncludes());
				reward.getListCollaborators().add(user);
			}
		}
		
		try{
			listIncludesUser.addAll(user.getProjectIncludes().get(this));
			user.getProjectIncludes().put(this, listIncludesUser);
		}catch(Exception err){
			user.getProjectIncludes().put(this, listIncludesUser);
		}
		
		
	}
	
	public void addComment(Comment comment){
		getListComments().add(comment);
	}
	
	public void addReward(Reward reward){
		getListRewards().add(reward);
	}
	
	
}
