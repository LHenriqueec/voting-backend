package com.example.voting.dto.agenda.list;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Info Session on Agenda")
public class SessionDTO {
	private int id;
	private int duration;
	private int qtdUsers;

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

	public int getQtdUsers() {
		return qtdUsers;
	}

	public void setQtdUsers(int qtdUsers) {
		this.qtdUsers = qtdUsers;
	}
}
