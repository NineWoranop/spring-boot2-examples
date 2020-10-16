package com.nineworanop.examplebackend01.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nineworanop.examplebackend01.dto.Point;
import com.nineworanop.examplebackend01.dto.PointsOfTriangle;

@SpringBootTest
class MathServiceImplTest {
	@Autowired
	private MathService service;

	@Test
	@DisplayName("Test areaOfTriangle Success")
	void testAreaOfTriangle() {
		// Given for input
		final PointsOfTriangle points = new PointsOfTriangle(new Point(13, 34), new Point(22, 21), new Point(11, 19));
		// Given for expected result
		final Float expectedResult = 80.5f;

		// When
		Float actualResult = service.areaOfTriangle(points);

		// Then
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	@DisplayName("Test plus Success")
	void testFindById() {
		// Given for input
		final int x = 4;
		final int y = 9;
		// Given for expected result
		final Integer expectedResult = 13;

		// When
		Integer actualResult = service.plus(x, y);

		// Then
		assertThat(actualResult).isEqualTo(expectedResult);
	}
}
