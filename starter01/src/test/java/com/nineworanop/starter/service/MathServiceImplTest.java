package com.nineworanop.starter.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nineworanop.starter.dto.Point;
import com.nineworanop.starter.dto.PointsOfTriangle;

@SpringBootTest
class MathServiceImplTest {
	@Autowired
	private MathService service;

	@Test
	@DisplayName("Test areaOfTriangle Success")
	void testAreaOfTriangle() {
		// Prepare expected result
		final Float expectedResult = 80.5f;

		// Prepare input
		final PointsOfTriangle points = new PointsOfTriangle(new Point(13, 34), new Point(22, 21), new Point(11, 19));

		// Execute the service call
		Float actualResult = service.areaOfTriangle(points);

		// Assert the response
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	@DisplayName("Test plus Success")
	void testFindById() {
		// Prepare expected result
		final Integer expectedResult = 13;

		// Prepare input
		final int x = 4;
		final int y = 9;

		// Execute the service call
		Integer actualResult = service.plus(x, y);

		// Assert the response
		assertThat(actualResult).isEqualTo(expectedResult);
	}
}
