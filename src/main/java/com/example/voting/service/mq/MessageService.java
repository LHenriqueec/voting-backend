package com.example.voting.service.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
	private RabbitTemplate template;

	public void sendMessage(Object message) {
		template.convertAndSend("vote", message);
	}
}
