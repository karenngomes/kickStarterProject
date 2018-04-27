package models;

import java.util.ArrayList;

public class KickStarter {
	private User currentUser;
	private ArrayList<User> listUsers;
	private ArrayList<Project> listProjects;
	
	public KickStarter() {
		this.currentUser = null;
		this.listUsers = new ArrayList<User>();
		this.listProjects = new ArrayList<Project>();
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public ArrayList<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(ArrayList<User> listUsers) {
		this.listUsers = listUsers;
	}

	public ArrayList<Project> getListProjects() {
		return listProjects;
	}

	public void setListProjects(ArrayList<Project> listProjects) {
		this.listProjects = listProjects;
	}
	
	public Integer getLastIdUser() {
		if(listUsers.size() != 0)
			return listUsers.get(listUsers.size()-1).getId();
		else
			return 1;
	} 
	
	public Integer getLastIdProject() {
		if(listProjects.size() != 0)
			return listProjects.get(listProjects.size()-1).getId();
		else
			return 1;
	}
	
	public void addUser(String name, String email, String password) {
		try{
			User user = new User(getLastIdUser()+1,name,email,password);
			this.listUsers.add(user);
		}catch(Exception exception){
			System.out.println("Nao foi possivel inserir este usuario");
		}
	}
	
	public User signIn(String email, String password) {
		for(User user : this.listUsers) {
			if(user.getEmail().equals(email)) {
				if(user.getPassword().equals(password)){
					return user;
				}
				break;
			}
		}
		
		return null;
	}
	
	
}
