package com.example.voting.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.voting.dto.agenda.create.CreateAgendaDTO;
import com.example.voting.dto.agenda.list.ListAllAgendaDTO;
import com.example.voting.service.AgendaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/agenda")
@Api(tags = "Agenda", value = "Agenda operations",
consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE)
public class AgendaController {

	@Autowired
	private AgendaService service;

	@GetMapping
	@ApiOperation(value = "List all agendas", responseContainer = "List")
	public @ResponseBody List<ListAllAgendaDTO> listAgendas() {
		return service.listAgendas();
	}

	@GetMapping("/disable/{id}")
	@ApiOperation(value = "Disable an agenda by id")
	public @ResponseBody void disableAgenda(@PathVariable int id) {
		service.disableAgenda(id);
	}

	@GetMapping("/result/{id}")
	@ApiOperation(value = "Detail result votes agenda")
	public @ResponseBody Map<String, Long> resultVotes(@PathVariable int id) {
		return service.resultVotes(id);
	}

	@PostMapping
	@ApiOperation(value = "Save an agenda",
			response = Integer.class)
	public @ResponseBody int saveAgenda(
			@ApiParam(value = "Agenda info to add")
			@RequestBody CreateAgendaDTO agenda) {
		return service.createAgenda(agenda);
	}
}
