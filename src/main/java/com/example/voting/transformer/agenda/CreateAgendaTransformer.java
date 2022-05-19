package com.example.voting.transformer.agenda;

import com.example.voting.dto.agenda.create.CreateAgendaDTO;
import com.example.voting.model.Agenda;
import com.example.voting.model.Session;
import com.example.voting.model.User;

public abstract class CreateAgendaTransformer {

	public static Agenda transform(CreateAgendaDTO agendaCreated) {
		Agenda agenda = transformAgenda(agendaCreated);
		agenda.setSession(transformSession(agendaCreated));
		return agenda;
	}

	private static Agenda transformAgenda(CreateAgendaDTO agendaCreated) {
		Agenda agenda = new Agenda();
		agenda.setSubject(agendaCreated.getAgenda().getSubject());
		return agenda;
	}

	private static Session transformSession(CreateAgendaDTO agendaCreated) {
		Session session = new Session();
		session.setDuration(agendaCreated.getSession().getDuration());
		session.setUsers(agendaCreated.getUsers().stream().map(userDTO -> {
			User user = new User();
			user.setCpf(userDTO.getCpf());
			user.setName(userDTO.getName());
			return user;
		}).toList());
		return session;
	}

}
