package com.example.voting.model;

import java.util.List;

import javax.persistence.ManyToMany;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@javax.persistence.Entity
@ApiModel(description = "Datails about de user")
public class User extends Entity {

	@ApiModelProperty(required = true, allowEmptyValue = false)
	private String cpf;
	
	@ApiModelProperty(required = true, allowEmptyValue = false)
	private String name;
	
	@ManyToMany(mappedBy = "users")
	private List<Session> session;

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
