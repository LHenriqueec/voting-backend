package com.example.voting.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import com.example.voting.task.FinishAgendaSchedule;

@Component
public class FactoryScheduler {

	@Autowired
	private AutowireCapableBeanFactory factory;

	public FinishAgendaSchedule createFinishAgendaSchedule(int idAgenda) {
		FinishAgendaSchedule finishSchedule = new FinishAgendaSchedule(idAgenda);
		factory.autowireBean(finishSchedule);
		return (FinishAgendaSchedule) factory.initializeBean(finishSchedule, "finishSchedule");
	}
}
