package com.example.voting.model;

import javax.persistence.OneToOne;

@javax.persistence.Entity
public class Agenda extends Entity {

	private String subject;
	
	@OneToOne
	private Session session;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
}
