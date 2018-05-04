package models;

import java.util.Calendar;

public class Comment {
	private String description;
	private Calendar issueDate;
	private User sentUser;

	public Comment(String description, Calendar issueDate,
			User sentUser) {
		this.description = description;
		this.issueDate = issueDate;
		this.sentUser = sentUser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Calendar issueDate) {
		this.issueDate = issueDate;
	}

	public User getSentUser() {
		return sentUser;
	}

	public void setSentUser(User sentUser) {
		this.sentUser = sentUser;
	}
	
	

}
