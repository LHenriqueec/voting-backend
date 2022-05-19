package com.example.voting.dto.agenda.create;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Create Agenda")
public class AgendaDTO {
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
