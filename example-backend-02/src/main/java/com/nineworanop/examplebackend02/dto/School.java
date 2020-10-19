package com.nineworanop.examplebackend02.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class School {
	@NonNull
	private Long id;

	@NonNull
	private String name;

}
