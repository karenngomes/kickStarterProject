package models.projects;

import java.util.ArrayList;

import models.Category;
import models.Comment;
import models.Project;
import models.Reward;
import models.User;

public class Progress extends Project{

	public Progress(User owner, Category category, String name, String description,
			Integer durationDays, Double goalMoney) {
		super(owner, category, name, description, durationDays, goalMoney);
	}
	
	public void addContributor(User user, Double quantity) {
		ArrayList<String> listIncludesUser = new ArrayList<String>();
		
		
		if(!user.equals(this.getOwner())) {
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
			
			System.out.println("Investimento realizado com sucesso!");
		}else {
			System.out.println("Nao foi possivel realizar este investimento");
		}
		
	}
	
	public void addComment(Comment comment){
		try{
			getListComments().add(comment);
			System.out.println("Comentario adicionado com sucesso!");
		}catch(Exception exception) {
			System.out.println("Nao foi possivel adicionar este comentario!");
		}
		
	}
	
	public void addReward(Reward reward){
		getListRewards().add(reward);
	}
	
	public void removeReward(String name){
		for(Reward reward : getListRewards()){
			if(reward.getName().equals(name)){
				getListRewards().remove(reward);
				System.out.println("Recompensa removida com sucesso!");
				return;
			}
		}
		
		System.out.println("Nao foi possivel remover esta recompensa!");
	}
	
	
}
