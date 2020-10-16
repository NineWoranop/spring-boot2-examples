package com.nineworanop.examplebackend02.repo.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.nineworanop.examplebackend02.dto.School;

class SchoolEntityTest {

	@Test
	@DisplayName("to() from Iterable<SchoolEntity> to List<School> success")
	void testTo() throws Exception {
		// Given for input
		Iterable<SchoolEntity> input = Arrays.asList(new SchoolEntity(1l, "School 111"), null, new SchoolEntity(2l, "School 222"), new SchoolEntity(3l, "School 333"), null);
		// Given for expected result
		List<School> expectedResult = Arrays.asList(new School(1l, "School 111"), null, new School(2l, "School 222"), new School(3l, "School 333"), null);

		// When
		List<School> actualResult = SchoolEntity.to(input);

		// Then
		assertThat(actualResult).isEqualTo(expectedResult);
	}
}
