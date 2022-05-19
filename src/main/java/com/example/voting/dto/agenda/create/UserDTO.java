package com.example.voting.dto.agenda.create;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Create User")
public class UserDTO {
	private String cpf;
	private String name;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
