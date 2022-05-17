package com.example.voting.model;

import javax.persistence.OneToOne;

@javax.persistence.Entity
public class Agenda extends Entity {

	private String subject;
	private boolean active = true;

	@OneToOne(mappedBy = "agenda")
	private Session session;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
