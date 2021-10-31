package com.nineworanop.schoolexample.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nineworanop.amqpexample.service.NotificationService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NotificationServiceImplTest {
	@Autowired
	private NotificationService service;

	@Test
	@DisplayName("Test produce Positive 1")
	void testProducePositive1() {
		// Execute the service call
		service.produce("Test message");
	}

}
