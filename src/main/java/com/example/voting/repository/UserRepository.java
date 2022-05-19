package com.example.voting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.voting.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	Iterable<User> findByNameContaining(@Param("name") String name);

	User findByCpf(@Param("cpf") String cpf);
}
