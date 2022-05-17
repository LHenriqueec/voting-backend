package com.example.voting.service;

import com.example.voting.model.Agenda;
import com.example.voting.repository.AgendaRepository;

@org.springframework.stereotype.Service
public class AgendaService extends Service<Agenda, AgendaRepository> {

	public void disableAgenda(int id) {
		findById(id).get().setActive(false);
	}
}
