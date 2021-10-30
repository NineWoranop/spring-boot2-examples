package com.nineworanop.schoolexample.repo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.nineworanop.schoolexample.repo.entity.SchoolEntity;
import com.nineworanop.schoolexample.repo.entity.querydsl.QSchoolEntity;
import com.querydsl.jpa.JPQLQuery;

@Repository
public class SchoolQueryRepository extends QuerydslRepositorySupport {

	public SchoolQueryRepository() {
		super(SchoolEntity.class);
	}

	public List<SchoolEntity> findNameContainingIgnoreCase(String name) {
		boolean isNotBlank = StringUtils.isNotBlank(name);
		QSchoolEntity qSchoolEntity = QSchoolEntity.schoolEntity;
		JPQLQuery<SchoolEntity> jpqlQuery = from(qSchoolEntity);
		if (isNotBlank) {
			jpqlQuery = jpqlQuery.where(qSchoolEntity.name.containsIgnoreCase(name));
		}
		return jpqlQuery.fetch();
	}

}
