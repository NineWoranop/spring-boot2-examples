package com.nineworanop.examplebackend02.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DtoTest {

	@Test
	@DisplayName("School(1L, \"School 1\")) success")
	void testSchoolSuccess() {
		// When
		School actualResult = new School(1L, "School 1");

		// Then
		assertThat(actualResult).hasNoNullFieldsOrProperties();
	}

	@Test
	@DisplayName("Student(1L, 1L, \"Student 1\") success")
	void testStudentSuccess() {
		// When
		Student actualResult = new Student(1L, 1L, "Student 1");

		// Then
		assertThat(actualResult).hasNoNullFieldsOrProperties();
	}
}
