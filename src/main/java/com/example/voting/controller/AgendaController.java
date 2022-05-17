package com.example.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.voting.model.Agenda;
import com.example.voting.service.AgendaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping(path = "/agenda")
@Api(tags = "Agenda", value = "Agenda operations",
consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE)
public class AgendaController {

	@Autowired
	private AgendaService service;

	@GetMapping
	@ApiOperation(value = "List all agendas",
			response = Agenda.class,
			responseContainer = "List")
	public @ResponseBody Iterable<Agenda> listAgendas() {
		return service.findAll();
	}

	@GetMapping("/disable/{id}")
	@ApiOperation(value = "Disable an agenda by id")
	public @ResponseBody void disableAgenda(@PathVariable int id) {
		service.disableAgenda(id);
	}

	@PostMapping
	@ApiOperation(value = "Save an agenda",
			response = Integer.class)
	public @ResponseBody int saveAgenda(
			@ApiParam(value = "Agenda info to add")
			@RequestBody Agenda agenda) {
		return service.save(agenda);
	}
}
