package com.example.voting.task;

import com.example.voting.service.AgendaService;

public class FinishAgendaSchedule implements Runnable {
	private final int id;
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
