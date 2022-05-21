package com.example.voting.service;

import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.voting.dto.agenda.create.CreateAgendaDTO;
import com.example.voting.dto.agenda.list.ListAllAgendaDTO;
import com.example.voting.model.Agenda;
import com.example.voting.model.Session;
import com.example.voting.model.User;
import com.example.voting.repository.AgendaRepository;
import com.example.voting.service.mq.MessageService;
import com.example.voting.transformer.agenda.CreateAgendaTransformer;
import com.example.voting.transformer.agenda.ListAgendaTransformer;
import com.example.voting.transformer.vote.DetailVotesTransformer;

@org.springframework.stereotype.Service
public class AgendaService extends Service<Agenda, AgendaRepository> {
	
	private Logger logger = LoggerFactory.getLogger(AgendaService.class);

	@Autowired
	private SessionService sessionService;

	@Autowired
	private UserService userService;

	@Autowired
	private MessageService messageService;

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

	@Transactional
	public void notifyEndedVoteSession(int sessionId) {
		Session session = sessionService.findById(sessionId).get();
		logger.info("Send message to ended vote session id: %d".formatted(sessionId));
		messageService.sendMessage(DetailVotesTransformer.transform(session.getVotes()));
	}

	public Map<String, Long> resultVotes(int id) {
		return DetailVotesTransformer.transform(findById(id).get().getSession().getVotes());
	}
}
