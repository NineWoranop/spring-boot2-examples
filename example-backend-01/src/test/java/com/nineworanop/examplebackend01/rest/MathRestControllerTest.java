package com.nineworanop.examplebackend01.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineworanop.examplebackend01.dto.Point;
import com.nineworanop.examplebackend01.dto.PointsOfTriangle;
import com.nineworanop.examplebackend01.service.MathService;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class MathRestControllerTest {

	@MockBean
	private MathService mockMathService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@DisplayName("POST /api/math/area/triangle success")
	void testAreaOfTriangleSuccess() throws Exception {
		// Given for input
		PointsOfTriangle points = new PointsOfTriangle(new Point(13, 34), new Point(22, 21), new Point(11, 19));
		String inputAsJson = objectMapper.writeValueAsString(points);
		// Given for mock the service
		final Float expectedResult = 80.5f;
		doReturn(expectedResult).when(mockMathService).areaOfTriangle(points);

		// When
		mockMvc.perform(post("/api/math/area/triangle").content(inputAsJson).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				// Then validate the response code and content type
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))

				// Then validate result
				.andExpect(mvcResult -> {
					String actualStr = mvcResult.getResponse().getContentAsString();
					Float actualResult = Float.valueOf(actualStr);
					assertThat(actualResult).isEqualTo(expectedResult);
				});
	}

	@Test
	@DisplayName("GET /api/math/plus success")
	void testPlusSuccess() throws Exception {
		// Given for mock the service
		final Integer expectedResult = 3;
		doReturn(expectedResult).when(mockMathService).plus(1, 2);

		// When
		mockMvc.perform(get("/api/math/plus?x=1&y=2"))
				// Then validate the response code and content type
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))

				// Then validate result
				.andExpect(mvcResult -> {
					String actualStr = mvcResult.getResponse().getContentAsString();
					Integer actualResult = Integer.valueOf(actualStr);
					assertThat(actualResult).isEqualTo(expectedResult);
				});
	}
}
