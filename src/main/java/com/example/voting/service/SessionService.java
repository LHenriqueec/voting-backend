package com.example.voting.service;

import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.example.voting.dto.session.detail.DetailSessionDTO;
import com.example.voting.factory.FactoryScheduler;
import com.example.voting.model.Session;
import com.example.voting.repository.SessionRepository;
import com.example.voting.transformer.session.DetailSessionTransformer;
import com.example.voting.util.DateUtil;

@org.springframework.stereotype.Service
public class SessionService extends Service<Session, SessionRepository> {

	private Logger logger = LoggerFactory.getLogger(AgendaService.class);

	@Autowired
	private ThreadPoolTaskScheduler scheduler;

	@Autowired
	private FactoryScheduler factory;

	@Transactional
	public void startSession(int id) {
		Session session = findById(id).get();
		session.setStartedAt(new Date());
		session.setEndedAt(DateUtil.plusMinutes(session.getStartedAt(), session.getDuration()));
		scheduler.schedule(factory.createFinishAgendaSchedule(id), session.getEndedAt());
		logger.info("Session %d started at : %s".formatted(id, session.getStartedAt()));
	}
	
	public List<DetailSessionDTO> detailAllSessions() {
		return StreamSupport.stream(findAll().spliterator(), false)
			.map(DetailSessionTransformer::transform)
			.toList();
	}

	public DetailSessionDTO detailSession(int sessionId) {
		Session session = findById(sessionId).get();
		return DetailSessionTransformer.transform(session);
	}

	public boolean sessionIsActive(Session session) {
		return repository.existsByIdAndEndedAtIsNull(session.getId());
	}
}
