package com.nineworanop.examplebackend02.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class School {
	@NonNull
	private Long id;

	@NonNull
	private String name;

}
