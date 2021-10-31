package com.nineworanop.amqpexample.service.listener;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

@Service
public class NotificationListenerService {

	private LinkedList<String> messages = new LinkedList<String>();

	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
		messages.addLast(message);
	}

	public String read() {
		if(messages.isEmpty()) {
			return null;
		}
		String message = messages.removeFirst();
		return message;
	}
}