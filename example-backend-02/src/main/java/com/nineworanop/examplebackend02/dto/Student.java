package com.nineworanop.examplebackend02.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Student {
	@NonNull
    private Long id;

	@NonNull
    private Long schoolId;

	@NonNull
    private String name;

}
