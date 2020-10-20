package com.nineworanop.examplebackend02.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineworanop.examplebackend02.dto.School;
import com.nineworanop.examplebackend02.service.SchoolService;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class SchoolRestControllerTest {

	@MockBean
	private SchoolService mockSchoolService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@DisplayName("GET /api/school/findAll success")
	void testFindAllSchoolsSuccess() throws Exception {
		// Given for mock the service
		final List<School> expectedResult = Arrays.asList(new School(1l, "School AAA"), new School(2l, "School BBB"), new School(3l, "School CCC"));
		doReturn(expectedResult).when(mockSchoolService).getSchools();

		// When
		mockMvc.perform(get("/api/school/findAll").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				// Then validate the response code and content type
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))

				// Then validate result
				.andExpect(mvcResult -> {
					String actualStr = mvcResult.getResponse().getContentAsString();
					TypeReference<List<School>> typeRef = new TypeReference<List<School>>() {
					};
					List<School> actualResult = objectMapper.readValue(actualStr, typeRef);
					assertThat(actualResult).isEqualTo(expectedResult);
				});
	}

}
