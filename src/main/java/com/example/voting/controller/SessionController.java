package com.example.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.voting.dto.session.detail.DetailSessionDTO;
import com.example.voting.service.SessionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
			response = DetailSessionDTO.class,
			responseContainer = "List")
	public @ResponseBody List<DetailSessionDTO> listSessions() {
		return service.detailAllSessions();
	}

	@GetMapping("{id}")
	@ApiOperation(value = "Detail a session", response = DetailSessionDTO.class)
	public @ResponseBody DetailSessionDTO findSession(@PathVariable int id) {
		return service.detailSession(id);
	}

	@GetMapping(path = "/start/{id}")
	@ApiOperation(value = "Start session voting")
	public @ResponseBody void startSession(@PathVariable int id) {
		service.startSession(id);
	}
}
