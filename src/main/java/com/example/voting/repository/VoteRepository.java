package com.example.voting.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.voting.model.Vote;

public interface VoteRepository extends CrudRepository<Vote, Integer> {

}
