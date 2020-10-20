package com.nineworanop.examplebackend02.repo.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentEntityTest {

	@Test
	@DisplayName("StudentEntity() success")
	void testSchoolSuccess() {
		// When
		StudentEntity actualResult = new StudentEntity();

		// Then
		assertThat(actualResult).hasAllNullFieldsOrProperties();
	}

}
