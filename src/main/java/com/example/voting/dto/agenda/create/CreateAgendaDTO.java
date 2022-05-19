package com.example.voting.dto.agenda.create;

import java.util.List;

public class CreateAgendaDTO {
	private AgendaDTO agenda;
	private SessionDTO session;
	private List<UserDTO> users;

	public AgendaDTO getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaDTO agenda) {
		this.agenda = agenda;
	}

	public SessionDTO getSession() {
		return session;
	}

	public void setSession(SessionDTO session) {
		this.session = session;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
}
