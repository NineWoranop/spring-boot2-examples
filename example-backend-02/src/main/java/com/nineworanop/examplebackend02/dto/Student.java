package com.nineworanop.examplebackend02.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Student {
	@NonNull
	private Long id;

	@NonNull
	private Long schoolId;

	@NonNull
	private String name;

}
