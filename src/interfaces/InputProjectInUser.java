package interfaces;

import models.User;
import models.projects.*;

public class InputProjectInUser {
	private User user;
	private Progress project;
	
	public InputProjectInUser(User user, Progress project) {
		this.user = user;
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public Progress getProject() {
		return project;
	}
	
}
