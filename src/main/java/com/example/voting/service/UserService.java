package com.example.voting.service;

import com.example.voting.model.User;
import com.example.voting.repository.UserRepository;

@org.springframework.stereotype.Service
public class UserService extends Service<User, UserRepository> {


	public Iterable<User> findByName(String name) {
		return repository.findByNameContaining(name);
	}
}
