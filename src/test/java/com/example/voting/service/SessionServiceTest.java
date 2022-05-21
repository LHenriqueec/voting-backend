package com.example.voting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.example.voting.dto.session.detail.DetailSessionDTO;
import com.example.voting.factory.FactoryScheduler;
import com.example.voting.model.Session;
import com.example.voting.model.User;
import com.example.voting.model.Vote;
import com.example.voting.repository.SessionRepository;

class SessionServiceTest {

	@InjectMocks
	private SessionService service;

	@Mock
	private SessionRepository repository;

	@Mock
	private ThreadPoolTaskScheduler scheduler;

	@Mock
	private FactoryScheduler factory;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testStartSession() {
		int idSession = 1;

		Session session = mock(Session.class);
		Optional<Session> optional = Optional.of(session);

		when(service.findById(idSession)).thenReturn(optional);
		when(session.getStartedAt()).thenReturn(new Date());

		service.startSession(idSession);

		verify(session).setStartedAt(any(Date.class));
		verify(session).setEndedAt(any(Date.class));
	}

	@Test
	public void testDetailAllSessions() {
		Session session1 = mock(Session.class);
		Session session2 = mock(Session.class);
		User user = mock(User.class);
		Vote vote = mock(Vote.class);
		List<User> users = Arrays.asList(user);
		List<Vote> votes = Arrays.asList(vote);
		List<Session> listSessions = Arrays.asList(session1, session2);

		when(repository.findAll()).thenReturn(listSessions);
		when(session1.getUsers()).thenReturn(users);
		when(session1.getVotes()).thenReturn(votes);
		when(vote.getUser()).thenReturn(user);

		List<DetailSessionDTO> sessions = service.detailAllSessions();

		assertEquals(2, sessions.size());
	}

	@Test
	public void testDetailSession() {
		int idSession = 1;

		User user = mock(User.class);
		Vote vote = mock(Vote.class);
		Session session = mock(Session.class);
		Optional<Session> optional = Optional.of(session);

		when(repository.findById(idSession)).thenReturn(optional);
		when(vote.getUser()).thenReturn(user);

		assertNotNull(service.detailAllSessions());
	}

}
