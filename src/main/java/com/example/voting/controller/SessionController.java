package com.example.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.voting.model.Session;
import com.example.voting.service.SessionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping(path="/session")
@Api(tags = "Session", value = "Session operations",
consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE)
public class SessionController {

	@Autowired
	private SessionService service;

	@GetMapping
	@ApiOperation(value = "List all sessions",
			response = Session.class,
			responseContainer = "List")
	public @ResponseBody Iterable<Session> listSessions() {
		return service.findAll();
	}

	@PostMapping
	@ApiOperation(value = "Register a session on agenda",
			response = Integer.class)
	public @ResponseBody int addSession(
			@ApiParam(value = "Session to register on agenda")
			@RequestBody Session session) {
		return service.save(session);
	}
}
