package com.nineworanop.schoolexample.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nineworanop.schoolexample.repo.entity.StudentEntity;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentQueryRepositoryTest {

	@Autowired
	private StudentQueryRepository repo;
	
	private static LocalDateTime getDate(final String dateStr, final String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);
		return dateTime;
	}

	@Test
	@DisplayName("findAllStudentsBySchoolId Positive")
	void testFindAllStudentsBySchoolIdPositive() {
		// Given for input
		final Long schoolId = 1L;
		// Given for expected result
		final String dateStr = "2010-01-01 00:00:00";
		final String pattern = "yyyy-MM-dd HH:mm:ss";
		final LocalDateTime dateTime = getDate(dateStr, pattern);
		final List<StudentEntity> expectedResult = Arrays.asList(new StudentEntity(1l, 1l, "Student 1", dateTime, dateTime));

		// When
		List<StudentEntity> actualResult = repo.findAllStudentsBySchoolId(schoolId);

		// Then
		assertThat(actualResult).isEqualTo(expectedResult);
	}
}
