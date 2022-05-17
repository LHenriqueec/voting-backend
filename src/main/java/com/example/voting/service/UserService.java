package com.example.voting.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.voting.model.User;
import com.example.voting.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public Iterable<User> findAll() {
		return repository.findAll();
	}

	public Optional<User> findById(int id) {
		return repository.findById(id);
	}

	public Iterable<User> findByName(String name) {
		return repository.findByNameContaining(name);
	}

	public int createUser(User user) {
		return repository.save(user).getId();
	}
}
