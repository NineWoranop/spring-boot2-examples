package com.nineworanop.amqpexample.service;

public interface NotificationService {
	void produce(String message);

	String consume();
}
