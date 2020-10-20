package com.nineworanop.examplebackend02.repo;

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

import com.nineworanop.examplebackend02.repo.entity.StudentEntity;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentQueryRepositoryTest {

	@Autowired
	private StudentQueryRepository repo;

	@Test
	@DisplayName("findAllStudentsBySchoolId success")
	void testFindAllStudentsBySchoolIdSuccess() {
		// Given for input
		final Long schoolId = 1L;
		// Given for expected result
		String dateStr = "2010-01-01 00:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);
		final List<StudentEntity> expectedResult = Arrays.asList(new StudentEntity(1l, 1l, "Student 1", dateTime, dateTime));

		// When
		List<StudentEntity> actualResult = repo.findAllStudentsBySchoolId(schoolId);

		// Then
		assertThat(actualResult).isEqualTo(expectedResult);
	}
}
