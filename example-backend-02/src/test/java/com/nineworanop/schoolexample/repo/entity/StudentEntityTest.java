package com.nineworanop.schoolexample.repo.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentEntityTest {

	@Test
	@DisplayName("StudentEntity() Positive")
	void testSchoolPositive() {
		// When
		StudentEntity actualResult = new StudentEntity();

		// Then
		assertThat(actualResult).hasAllNullFieldsOrProperties();
	}

}
