package com.nineworanop.amqpexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResult {

	@NonNull
	private StatusEnum status;

}