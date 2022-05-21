package com.example.voting.task;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.voting.service.AgendaService;

public class FinishAgendaSchedule implements Runnable {
	private final int id;

	@Autowired
	private AgendaService service;

	public FinishAgendaSchedule(int id) {
		this.id = id;
		this.service = new AgendaService();
	}

	@Override
	public void run() {
		service.notifyEndedVoteSession(id);
	}

}
