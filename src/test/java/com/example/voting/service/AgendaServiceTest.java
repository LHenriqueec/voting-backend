package com.example.voting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.voting.dto.agenda.create.AgendaDTO;
import com.example.voting.dto.agenda.create.CreateAgendaDTO;
import com.example.voting.dto.agenda.create.SessionDTO;
import com.example.voting.dto.agenda.create.UserDTO;
import com.example.voting.dto.agenda.list.ListAllAgendaDTO;
import com.example.voting.model.Agenda;
import com.example.voting.model.Session;
import com.example.voting.model.User;
import com.example.voting.repository.AgendaRepository;

class AgendaServiceTest {

	@InjectMocks
	private AgendaService service;

	@Mock
	protected AgendaRepository repository;

	@Mock
	private SessionService sessionService;

	@Mock
	private UserService userService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCrateAgenda() {
		final String existendCpf = "123456789";

		CreateAgendaDTO agendaCreated = mock(CreateAgendaDTO.class);
		Agenda newAgenda = mock(Agenda.class);
		AgendaDTO agendaDTO = mock(AgendaDTO.class);
		SessionDTO sessionDTO = mock(SessionDTO.class);
		User existendUser = mock(User.class);
		UserDTO user1 = mock(UserDTO.class);
		UserDTO user2 = mock(UserDTO.class);
		List<UserDTO> users = Arrays.asList(user1, user2);

		when(newAgenda.getId()).thenReturn(1);
		when(agendaCreated.getAgenda()).thenReturn(agendaDTO);
		when(agendaCreated.getSession()).thenReturn(sessionDTO);
		when(agendaCreated.getUsers()).thenReturn(users);
		when(agendaDTO.getSubject()).thenReturn("Subject Test");
		when(user2.getCpf()).thenReturn(existendCpf);
		when(userService.findByCpf(existendCpf)).thenReturn(existendUser);
		when(repository.save(any(Agenda.class))).thenReturn(newAgenda);

		int idAgenda = service.createAgenda(agendaCreated);

		verify(userService, times(1)).save(any(User.class));
		verify(sessionService).save(any(Session.class));
		assertEquals(1, idAgenda);
	}

	@Test
	public void testListAgendas() {
		Agenda agenda = mock(Agenda.class);
		Session session = mock(Session.class);
		List<Agenda> agendas = Arrays.asList(agenda);

		when(agenda.getSession()).thenReturn(session);
		when(repository.findAll()).thenReturn(agendas);

		List<ListAllAgendaDTO> listAgendas = service.listAgendas();

		assertEquals(1, listAgendas.size());
	}

	@Test
	public void testDisableAgenda() {
		int idAgenda = 1;

		Agenda agenda = mock(Agenda.class);
		Optional<Agenda> optional = Optional.of(agenda);

		when(repository.findById(idAgenda)).thenReturn(optional);
		service.disableAgenda(idAgenda);

		verify(agenda).setActive(false);
	}

}
