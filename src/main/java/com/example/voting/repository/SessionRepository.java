package com.example.voting.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.voting.model.Session;

public interface SessionRepository extends CrudRepository<Session, Integer> {

}
