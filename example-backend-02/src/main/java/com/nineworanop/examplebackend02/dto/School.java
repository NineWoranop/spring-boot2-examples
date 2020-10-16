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
public class School {
	@NonNull
	private Long id;

	@NonNull
	private String name;

	public School() {
		this.id = 0L;
		this.name = "";
	}
}
