package com.example.voting.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.voting.model.Agenda;

public interface AgendaRepository extends CrudRepository<Agenda, Integer> {

}
