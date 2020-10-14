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
	@DisplayName("POST /rest/math/area/triangle success")
	void testAreaOfTriangleSuccess() throws Exception {
		// Prepare input
		PointsOfTriangle points = new PointsOfTriangle(new Point(13, 34), new Point(22, 21), new Point(11, 19));
		String inputAsJson = objectMapper.writeValueAsString(points);

		// Setup our mocked service
		final Float expectedResult = 80.5f;
		doReturn(expectedResult).when(mockMathService).areaOfTriangle(points);

		// Execute the POST request
		mockMvc.perform(post("/rest/math/area/triangle").content(inputAsJson).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				// Validate the response code and content type
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))

				// Validate result
				.andExpect(mvcResult -> {
					String actualStr = mvcResult.getResponse().getContentAsString();
					Float actualResult = Float.valueOf(actualStr);
					assertThat(actualResult).isEqualTo(expectedResult);
				});
	}

	@Test
	@DisplayName("GET /rest/math/plus success")
	void testPlusSuccess() throws Exception {
		// Setup our mocked service
		final Integer expectedResult = 3;
		doReturn(expectedResult).when(mockMathService).plus(1, 2);

		// Execute the GET request
		mockMvc.perform(get("/rest/math/plus?x=1&y=2"))
				// Validate the response code and content type
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))

				// Validate result
				.andExpect(mvcResult -> {
					String actualStr = mvcResult.getResponse().getContentAsString();
					Integer actualResult = Integer.valueOf(actualStr);
					assertThat(actualResult).isEqualTo(expectedResult);
				});
	}
}