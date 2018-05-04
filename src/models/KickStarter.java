package models;

import java.util.ArrayList;

import models.projects.Progress;

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
	
	public Project getProjectByName(String name) {
		for(Project project : listProjects){
			if(project.getName().equals(name))
				return project;
		}
		
		System.out.println("Nao foi possivel encontrar nenhum projeto com este nome");
		return null;
	}

	public void addUser(String name, String email, String password) {
		try{
			User user = new User(name,email,password);
			this.listUsers.add(user);
			System.out.println("Cadastro efetuado com sucesso!");
		}catch(Exception exception){
			System.out.println("Nao foi possivel finalizar esta operacao");
		}
	}
	
	public void addProject(Progress project) {
		try{
			this.listProjects.add(project);
			System.out.println("Projeto cadastrado com sucesso!");
		}catch(Exception exception) {
			System.out.println("Nao foi possivel cadastrar este projeto!");
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
	
	public boolean checkUserByEmail(String email) {
		for(User user : getListUsers()) {
			if(user.getEmail().equals(email) && !user.equals(currentUser))
				return true;
		}
		
		return false;
	}
	
	public User getUserByEmail(String email) {
		for(User user : getListUsers()) {
			if(user.getEmail().equals(email))
				return user;
		}
		
		return null;
	}
	
	public boolean checkProjectName(String name) {
		for(Project project : listProjects){
			if(project.getName().equals(name))
				return false;
		}
		return true;
	}
	
	
}
