package com.nineworanop.amqpexample.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nineworanop.amqpexample.service.listener.NotificationListenerService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${example.rabbitmq.exchange}")
	private String exchange;

	@Value("${example.rabbitmq.routingkey}")
	private String routingkey;
	
	@Autowired
	private NotificationListenerService listenerService;

	@Override
	public void produce(String message) {
		amqpTemplate.convertAndSend(exchange, routingkey, message);
		System.out.println("Sent msg <" + message + ">");
	}

	@Override
	public String consume() {
		return listenerService.read();
	}

}
