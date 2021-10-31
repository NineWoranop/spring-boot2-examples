package com.nineworanop.schoolexample.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineworanop.amqpexample.dto.NotificationMessage;
import com.nineworanop.amqpexample.dto.NotificationResult;
import com.nineworanop.amqpexample.dto.StatusEnum;
import com.nineworanop.amqpexample.service.NotificationService;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class NotificationRestControllerTest {

	@MockBean
	private NotificationService mockSchoolService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@DisplayName("POST /api/notification/produce Positive 1")
	void testFindAllSchoolsPositive1() throws Exception {
		// Given for input
		final String message = "Test Message";
		final NotificationMessage notificationMessage = new NotificationMessage(message);
		final String notificationJson = objectMapper.writeValueAsString(notificationMessage);
		
		// Given for mock the service
		final NotificationResult expectedResult = new NotificationResult(StatusEnum.KO);

		// When
		ResultActions result = mockMvc.perform(post("/api/notification/produce")
				.content(notificationJson)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		// Then validate the response code and content type
		result.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))

				// Then validate result
				.andExpect(mvcResult -> {
					String actualStr = mvcResult.getResponse().getContentAsString();
					TypeReference<NotificationResult> typeRef = new TypeReference<NotificationResult>() {
					};
					NotificationResult actualResult = objectMapper.readValue(actualStr, typeRef);
					assertThat(actualResult).isEqualTo(expectedResult);
					verify(mockSchoolService, times(1)).produce(message);
				});
	}

}
