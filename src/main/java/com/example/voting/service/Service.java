package com.example.voting.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.example.voting.model.Entity;

public abstract class Service<T extends Entity, R extends CrudRepository<T, Integer>> {

	@Autowired
	protected R repository;

	public Iterable<T> findAll() {
		return repository.findAll();
	}

	public Optional<T> findById(int id) {
		return repository.findById(id);
	}

	public int save(T entity) {
		return repository.save(entity).getId();
	}
}
