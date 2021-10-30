package com.nineworanop.schoolexample.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class Student {
	@NonNull
	private Long id;

	@NonNull
	private Long schoolId;

	@NonNull
	private String name;

}
