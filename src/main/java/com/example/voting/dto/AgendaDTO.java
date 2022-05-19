package com.example.voting.dto;

public class AgendaDTO {
	private int id;
	private String subject;
	private boolean active = true;
	private SessionDTO session;

	public AgendaDTO(int id, String subject, boolean active, SessionDTO session) {
		this.id = id;
		this.subject = subject;
		this.active = active;
		this.session = session;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public SessionDTO getSession() {
		return session;
	}

	public void setSession(SessionDTO session) {
		this.session = session;
	}
}
