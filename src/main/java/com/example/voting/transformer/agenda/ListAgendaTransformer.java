package com.example.voting.transformer.agenda;

import com.example.voting.dto.agenda.list.ListAllAgendaDTO;
import com.example.voting.dto.agenda.list.SessionDTO;
import com.example.voting.model.Agenda;
import com.example.voting.model.Session;

public abstract class ListAgendaTransformer {

	public static ListAllAgendaDTO transform(Agenda agenda) {
		ListAllAgendaDTO listAgenda = new ListAllAgendaDTO();
		listAgenda.setId(agenda.getId());
		listAgenda.setSubject(agenda.getSubject());
		listAgenda.setActive(agenda.isActive());

		listAgenda.setSession(transformSession(agenda));
		return listAgenda;
	}

	private static SessionDTO transformSession(Agenda agenda) {
		Session session = agenda.getSession();
		SessionDTO sessionDTO = new SessionDTO();
		sessionDTO.setId(session.getId());
		sessionDTO.setDuration(session.getDuration());
		sessionDTO.setQtdUsers(session.getUsers().size());
		return sessionDTO;
	}
}
