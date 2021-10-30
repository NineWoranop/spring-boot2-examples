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

import com.nineworanop.schoolexample.repo.entity.SchoolEntity;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SchoolQueryRepositoryTest {

	@Autowired
	private SchoolQueryRepository repo;
	
	private static LocalDateTime getDate(final String dateStr, final String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);
		return dateTime;
	}

	@Test
	@DisplayName("findByNameIgnoreCase Positive 1")
	void testFindByNameIgnoreCasePositive1() {
		// Given for input
		final String name = "bbb";
		// Given for expected result
		final String dateStr = "2010-01-01 00:00:00";
		final String pattern = "yyyy-MM-dd HH:mm:ss";
		final LocalDateTime dateTime = getDate(dateStr, pattern);
		final List<SchoolEntity> expectedResult = Arrays.asList(new SchoolEntity(2l, "School BBB", dateTime, dateTime));

		// When
		List<SchoolEntity> actualResult = repo.findNameContainingIgnoreCase(name);

		// Then
		assertThat(actualResult).isEqualTo(expectedResult);
	}
}
