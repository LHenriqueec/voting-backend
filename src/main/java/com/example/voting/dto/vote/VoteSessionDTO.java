package com.example.voting.dto.vote;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Vote on Session")
public class VoteSessionDTO implements Serializable {
	private static final long serialVersionUID = 7438451895954955613L;

	private int userId;
	private int sessionId;

	@ApiModelProperty(allowableValues = "y, n")
	private String value;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
