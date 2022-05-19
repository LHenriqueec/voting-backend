package com.example.voting.dto;

import java.util.Date;
import java.util.List;

import com.example.voting.model.User;

public class SessionDTO {
	private int id;
	private Date startedAt;
	private Date endedAt;
	private List<User> users;

	public SessionDTO(int id, Date startedAt, Date endedAt, List<User> users) {
		this.id = id;
		this.startedAt = startedAt;
		this.endedAt = endedAt;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public Date getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(Date endedAt) {
		this.endedAt = endedAt;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
