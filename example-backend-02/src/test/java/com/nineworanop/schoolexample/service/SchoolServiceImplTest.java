package com.nineworanop.schoolexample.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nineworanop.schoolexample.dto.School;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SchoolServiceImplTest {
	@Autowired
	private SchoolService service;

	@Test
	@DisplayName("Test getSchools Positive 1")
	void testGetSchoolsPositive1() {
		// Given for expected result
		final List<School> expectedResult = Arrays.asList(new School(1l, "School AAA"), new School(2l, "School BBB"), new School(3l, "School CCC"));

		// Execute the service call
		List<School> actualResult = service.getSchools();

		// Assert the response
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	@DisplayName("Test findSchoolsByNameContainingIgnoreCase Positive 1")
	void testFindSchoolsByNameContainingIgnoreCasePositive1() {
		// Given for expected result
		final List<School> expectedResult = Arrays.asList(new School(1l, "School AAA"), new School(2l, "School BBB"), new School(3l, "School CCC"));

		// Execute the service call
		List<School> actualResult = service.findSchoolsByNameContainingIgnoreCase("School");

		// Assert the response
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	@DisplayName("Test findSchoolsByNameContainingIgnoreCase Positive 2")
	void testFindSchoolsByNameContainingIgnoreCasePositive2() {
		// Given for expected result
		final List<School> expectedResult = Arrays.asList(new School(1l, "School AAA"));

		// Execute the service call
		List<School> actualResult = service.findSchoolsByNameContainingIgnoreCase("AAA");

		// Assert the response
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	@DisplayName("Test findSchoolsByNameContainingIgnoreCase Positive 3")
	void testFindSchoolsByNameContainingIgnoreCasePositive3() {
		// Given for expected result
		final List<School> expectedResult = Arrays.asList(new School(3l, "School CCC"));

		// Execute the service call
		List<School> actualResult = service.findSchoolsByNameContainingIgnoreCase("ccc");

		// Assert the response
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	@DisplayName("Test findSchoolsByNameContainingIgnoreCase Negative 1")
	void testFindSchoolsByNameContainingIgnoreCaseNegative1() {
		// Given for expected result
		final List<School> expectedResult = Arrays.asList(new School(1l, "School AAA"), new School(2l, "School BBB"), new School(3l, "School CCC"));

		// Execute the service call
		List<School> actualResult = service.findSchoolsByNameContainingIgnoreCase("");

		// Assert the response
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	@DisplayName("Test findSchoolsByNameContainingIgnoreCase Negative 2")
	void testFindSchoolsByNameContainingIgnoreCaseNegative2() {
		// Given for expected result
		final List<School> expectedResult = Arrays.asList(new School(1l, "School AAA"), new School(2l, "School BBB"), new School(3l, "School CCC"));

		// Execute the service call
		List<School> actualResult = service.findSchoolsByNameContainingIgnoreCase(null);

		// Assert the response
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	@DisplayName("Test findSchoolsByNameContainingIgnoreCase Negative 3")
	void testSchoolsByNameContainingIgnoreCaseNegative3() {
		// Given for expected result
		final List<School> expectedResult = Arrays.asList(new School(1l, "School AAA"), new School(2l, "School BBB"), new School(3l, "School CCC"));

		// Execute the service call
		List<School> actualResult = service.findSchoolsByNameContainingIgnoreCase(" ");

		// Assert the response
		assertThat(actualResult).isEqualTo(expectedResult);
	}

}
