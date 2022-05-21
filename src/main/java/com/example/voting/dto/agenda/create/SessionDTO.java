package com.example.voting.dto.agenda.create;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Create Session")
public class SessionDTO {
	private int duration = 1; // default 1 min

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
