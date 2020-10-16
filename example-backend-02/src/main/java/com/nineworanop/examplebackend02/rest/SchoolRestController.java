package com.nineworanop.examplebackend02.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nineworanop.examplebackend02.dto.School;
import com.nineworanop.examplebackend02.service.SchoolService;

@RestController
@RequestMapping("/api/school")
public class SchoolRestController {

	private final SchoolService schoolService;

	@Autowired
	public SchoolRestController(final SchoolService schoolService) {
		this.schoolService = schoolService;
	}

	@GetMapping(path = "/findAll")
	public List<School> findAll() {
		return schoolService.getSchools();
	}
}
