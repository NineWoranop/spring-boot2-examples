package com.nineworanop.examplebackend02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nineworanop.examplebackend02.dto.School;
import com.nineworanop.examplebackend02.repo.SchoolCRUDRepository;
import com.nineworanop.examplebackend02.repo.entity.SchoolEntity;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolCRUDRepository repo;

	@Override
	public List<School> getSchools() {
		Iterable<SchoolEntity> list = repo.findAll();
		return SchoolEntity.to(list);
	}

}
