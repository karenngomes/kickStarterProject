package models;

import java.util.Calendar;

public class Comment {
	private Integer id;
	private String description;
	private Calendar issueDate;
	private User sentUser;

	public Comment(Integer id, String description, Calendar issueDate,
			User sentUser) {
		super();
		this.id = id;
		this.description = description;
		this.issueDate = issueDate;
		this.sentUser = sentUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
