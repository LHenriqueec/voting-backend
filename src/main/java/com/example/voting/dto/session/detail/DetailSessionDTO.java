package com.example.voting.dto.session.detail;

import java.util.Date;
import java.util.List;

public class DetailSessionDTO {

	private int id;
	private int duration;
	private Date startedAt;
	private Date endedAt;
	private List<DetailUserDTO> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
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

	public List<DetailUserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<DetailUserDTO> users) {
		this.users = users;
	}
}
