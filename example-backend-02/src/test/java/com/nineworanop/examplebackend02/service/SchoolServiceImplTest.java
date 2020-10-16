package com.nineworanop.examplebackend02.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nineworanop.examplebackend02.dto.School;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SchoolServiceImplTest {
	@Autowired
	private SchoolService service;

	@Test
	@DisplayName("Test getSchools Success")
	void testGetSchools() {
		// Given for expected result
		final List<School> expectedResult = Arrays.asList(new School(1l, "School AAA"), new School(2l, "School BBB"), new School(3l, "School CCC"));

		// Execute the service call
		List<School> actualResult = service.getSchools();

		// Assert the response
		assertThat(actualResult).isEqualTo(expectedResult);
	}

}
