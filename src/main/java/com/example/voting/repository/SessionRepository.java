package com.example.voting.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.example.voting.model.Session;

public interface SessionRepository extends CrudRepository<Session, Integer> {
	boolean existsByIdAndEndedAtIsGreaterThanEqual(int id, Date now);
}
