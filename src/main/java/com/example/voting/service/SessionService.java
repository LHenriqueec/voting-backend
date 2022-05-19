package com.example.voting.service;

import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import com.example.voting.dto.session.detail.DetailSessionDTO;
import com.example.voting.model.Session;
import com.example.voting.repository.SessionRepository;
import com.example.voting.transformer.session.DetailSessionTransformer;
import com.example.voting.util.DateUtil;

@org.springframework.stereotype.Service
public class SessionService extends Service<Session, SessionRepository> {

	@Transactional
	public void startSession(int id) {
		Session session = findById(id).get();
		session.setStartedAt(new Date());
		session.setEndedAt(DateUtil.plusMinutes(session.getStartedAt(), session.getDuration()));
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
}
