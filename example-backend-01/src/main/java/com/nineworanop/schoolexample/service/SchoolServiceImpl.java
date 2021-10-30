package com.nineworanop.schoolexample.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.nineworanop.schoolexample.dto.School;

@Service
public class SchoolServiceImpl implements SchoolService {
	private List<School> schools = Arrays.asList(new School(1l, "School AAA"), new School(2l, "School BBB"), new School(3l, "School CCC"));

	@Override
	public List<School> getSchools() {
		return schools;
	}

	@Override
	public List<School> findSchoolsByNameContainingIgnoreCase(String name) {
		boolean isNotBlank = StringUtils.isNotBlank(name);
		if (isNotBlank) {
			Predicate<School> containsName = school -> StringUtils.containsIgnoreCase(school.getName(), name);
			List<School> filteredList = schools.stream().filter(containsName).collect(Collectors.toList());
			return filteredList;
		} else {
			return schools;
		}
	}

}
