package com.nineworanop.amqpexample.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nineworanop.amqpexample.dto.NotificationMessage;
import com.nineworanop.amqpexample.dto.NotificationResult;
import com.nineworanop.amqpexample.dto.StatusEnum;
import com.nineworanop.amqpexample.service.NotificationService;

@RestController
@RequestMapping("/api/notification")
public class NotificationRestController {

	private final NotificationService notificationService;

	@Autowired
	public NotificationRestController(final NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@PostMapping(path = "/produce", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationResult> create(@RequestBody NotificationMessage msg) {
		notificationService.produce(msg.getMessage());
		return new ResponseEntity<>(new NotificationResult(StatusEnum.KO), HttpStatus.OK);
	}

	@GetMapping(path = "/consume")
	public String consume() {
		return notificationService.consume();
	}

//	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid request") // 400
//	@ExceptionHandler(MismatchedInputException.class)
//	public void invalidRequest(HttpServletRequest req, MismatchedInputException ex) {
//		System.err.println("Request: " + req.getRequestURL() + " raised " + ex);
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", ex);
//		mav.addObject("url", req.getRequestURL());
//		mav.setViewName("error");
//		
//	}
//
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
//		System.err.println("Request: " + req.getRequestURL() + " raised " + ex);
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", ex);
//		mav.addObject("url", req.getRequestURL());
//		mav.setViewName("error");
//		return mav;
//	}
}
