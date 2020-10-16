package com.nineworanop.examplebackend02.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {
	@NonNull
	private Long id;

	@NonNull
	private Long schoolId;

	@NonNull
	private String name;

}
