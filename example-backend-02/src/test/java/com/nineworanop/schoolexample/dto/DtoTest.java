package com.nineworanop.schoolexample.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DtoTest {

	@Test
	@DisplayName("School(1L, \"School 1\")) Positive")
	void testSchoolPositive() {
		// When
		School actualResult = new School(1L, "School 1");

		// Then
		assertThat(actualResult).hasNoNullFieldsOrProperties();
	}

	@Test
	@DisplayName("Student(1L, 1L, \"Student 1\") Positive")
	void testStudentPositive() {
		// When
		Student actualResult = new Student(1L, 1L, "Student 1");

		// Then
		assertThat(actualResult).hasNoNullFieldsOrProperties();
	}
}
