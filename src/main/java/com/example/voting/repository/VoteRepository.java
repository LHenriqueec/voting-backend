package com.example.voting.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.voting.model.Session;
import com.example.voting.model.User;
import com.example.voting.model.Vote;

public interface VoteRepository extends CrudRepository<Vote, Integer> {

	boolean existsByUserAndSession(User user, Session session);
}
