package com.example.voting.model;

import javax.persistence.ManyToOne;

@javax.persistence.Entity
public class Vote extends Entity {

	@ManyToOne
	private User user;

	@ManyToOne
	private Session session;

	private String value;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
