package com.example.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.voting.dto.vote.VoteSessionDTO;
import com.example.voting.service.VoteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(path = "/vote")
@Api(tags = "Vote", value = "Vote operations",
consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {

	@Autowired
	private VoteService service;

	@PostMapping
	@ApiOperation(value = "To a vote on a session")
	public @ResponseBody int toVote(@RequestBody VoteSessionDTO vote) {
		return service.registerVote(vote);
	}
}
