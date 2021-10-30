package com.nineworanop.schoolexample.repo.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.nineworanop.schoolexample.dto.School;

class SchoolEntityTest {

	private static LocalDateTime getDate(final String dateStr, final String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);
		return dateTime;
	}

	@Test
	@DisplayName("SchoolEntity() Positive")
	void testSchoolEntity1Positive() {
		// When
		SchoolEntity actualResult = new SchoolEntity();
		AbstractAuditingEntity actualParentResult = actualResult;

		// Then
		assertThat(actualResult).hasAllNullFieldsOrProperties();
		assertThat(actualParentResult).hasAllNullFieldsOrProperties();
	}

	@Test
	@DisplayName("SchoolEntity() Positive")
	void testSchoolEntity2Positive() {
		// Given for input
		final String dateStr = "2010-01-01 00:00:00";
		final String pattern = "yyyy-MM-dd HH:mm:ss";
		final LocalDateTime dateTime = getDate(dateStr, pattern);
		// When
		SchoolEntity actualResult = SchoolEntity.builder().createdDate(dateTime).lastModifiedDate(dateTime).id(1L).name("School 1").build();
		AbstractAuditingEntity actualParentResult = actualResult;

		// Then
		assertThat(actualResult).hasNoNullFieldsOrProperties();
		assertThat(actualParentResult).hasNoNullFieldsOrProperties();
	}

	@Test
	@DisplayName("to() from Iterable<SchoolEntity> to List<School> Positive")
	void testTo() throws Exception {
		// Given for input
		final String dateStr = "2010-01-01 00:00:00";
		final String pattern = "yyyy-MM-dd HH:mm:ss";
		final LocalDateTime dateTime = getDate(dateStr, pattern);
		Iterable<SchoolEntity> input = Arrays.asList(SchoolEntity.builder().createdDate(dateTime).lastModifiedDate(dateTime).id(1L).name("School 111").build(), null,
				SchoolEntity.builder().createdDate(dateTime).lastModifiedDate(dateTime).id(2L).name("School 222").build(),
				SchoolEntity.builder().createdDate(dateTime).lastModifiedDate(dateTime).id(3L).name("School 333").build(), null);
		// Given for expected result
		List<School> expectedResult = Arrays.asList(new School(1l, "School 111"), null, new School(2l, "School 222"), new School(3l, "School 333"), null);

		// When
		List<School> actualResult = SchoolEntity.to(input);

		// Then
		assertThat(actualResult).isEqualTo(expectedResult);
		assertThat(actualResult.get(0)).hasNoNullFieldsOrProperties();
	}
}
