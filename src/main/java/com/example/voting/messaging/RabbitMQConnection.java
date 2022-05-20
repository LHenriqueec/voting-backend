package com.example.voting.messaging;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection {
	private static final String NAME_EXCHANGE = "amq_direct";
	private AmqpAdmin amqpAdmin;

	public RabbitMQConnection(AmqpAdmin amqpAdmin) {
		this.amqpAdmin = amqpAdmin;
	}

	private Queue queue(String name) {
		boolean durable = true;
		boolean exclusive = false;
		boolean autoDelete = false;

		return new Queue(name, durable, exclusive, autoDelete);
	}

	private DirectExchange directExchange() {
		return new DirectExchange(NAME_EXCHANGE);
	}

	private Binding binding(Queue queue, DirectExchange exchange) {
		return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), queue.getName(),
				null);
	}

	@PostConstruct
	private void add() {
		Queue queue = queue("vote");
		DirectExchange exchange = directExchange();
		Binding binding = binding(queue, exchange);

		amqpAdmin.declareQueue(queue);
		amqpAdmin.declareExchange(exchange);
		amqpAdmin.declareBinding(binding);
	}
}
