package com.example.voting.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.voting.dto.agenda.create.CreateAgendaDTO;
import com.example.voting.dto.agenda.list.ListAllAgendaDTO;
import com.example.voting.model.Agenda;
import com.example.voting.model.Session;
import com.example.voting.model.User;
import com.example.voting.repository.AgendaRepository;
import com.example.voting.transformer.agenda.CreateAgendaTransformer;
import com.example.voting.transformer.agenda.ListAgendaTransformer;

@org.springframework.stereotype.Service
public class AgendaService extends Service<Agenda, AgendaRepository> {
	
	@Autowired
	private SessionService sessionService;

	@Autowired
	private UserService userService;

	@Transactional
	public int createAgenda(CreateAgendaDTO agendaCreated) {
		Agenda agenda = CreateAgendaTransformer.transform(agendaCreated);
		saveUsers(agenda.getSession().getUsers());
		saveSession(agenda.getSession());
		saveAgenda(agenda);
		return agenda.getId();
	}

	private void saveUsers(List<User> users) {
		users.forEach(user -> {
			int id = 0;
			User findedUser = userService.findByCpf(user.getCpf());
			if (findedUser == null) {
				id = userService.save(user);
			} else
				id = findedUser.getId();
			user.setId(id);
		});
	}

	private void saveSession(Session session) {
		int id = sessionService.save(session);
		session.setId(id);
	}

	private void saveAgenda(Agenda agenda) {
		int id = save(agenda);
		agenda.setId(id);
		agenda.getSession().setAgenda(agenda);
	}

	public List<ListAllAgendaDTO> listAgendas() {
		return StreamSupport.stream(super.findAll().spliterator(), false)
		.map(ListAgendaTransformer::transform)
		.toList();
	}

	@Transactional
	public void disableAgenda(int id) {
		findById(id).get().setActive(false);
	}

	public Map<String, Long> resultVotes(int id) {
		return findById(id).get().getSession().getVotes().stream()
				.collect(Collectors.groupingBy(vote -> vote.getValue(), Collectors.counting()));
	}
}
