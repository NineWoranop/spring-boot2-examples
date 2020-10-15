package com.nineworanop.examplebackend02.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nineworanop.examplebackend02.dto.School;
import com.nineworanop.examplebackend02.repo.SchoolCRUDRepository;
import com.nineworanop.examplebackend02.repo.entity.SchoolEntity;

public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolCRUDRepository repo;

	@Override
	public List<School> getSchools() {
		ArrayList<School> result = new ArrayList<>();
		Iterable<SchoolEntity> list = repo.findAll();
		Iterator<SchoolEntity> it = list.iterator();
		while (it.hasNext()) {
			SchoolEntity item = it.next();
			result.add(item.toSchool());
		}
		return result;
	}

}
