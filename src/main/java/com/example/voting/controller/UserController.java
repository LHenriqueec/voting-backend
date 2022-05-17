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

import com.example.voting.model.User;
import com.example.voting.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping(path="/users")
@Api(tags = "User", value = "User operations",
consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	@ApiOperation(value = "Find all users",
			response = User.class,
			responseContainer = "List")
	public @ResponseBody Iterable<User> listUsers() {
		return service.findAll();
	}

	@GetMapping(path="{name}")
	@ApiOperation(value = "Find users by name",
			response = User.class,
			responseContainer = "List")
	public @ResponseBody Iterable<User> usersByName(@PathVariable  String name) {
		System.out.println(name);
		return service.findByName(name);
	}

	@PostMapping
	@ApiOperation(value = "Create a user",
			response = Integer.class)
	public @ResponseBody int addUser(
			@ApiParam(value = "User info to add on system", required = true, example = "{cpf: '123', name: 'Fernando'}")
			@RequestBody User user) {
		return service.createUser(user);
	}
}
