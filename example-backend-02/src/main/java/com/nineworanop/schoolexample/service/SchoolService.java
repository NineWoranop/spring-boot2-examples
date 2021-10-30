package com.nineworanop.schoolexample.service;

import java.util.List;

import com.nineworanop.schoolexample.dto.School;

public interface SchoolService {
	List<School> getSchools();
	List<School> findSchoolsByNameContainingIgnoreCase(String name);
}
