package com.nineworanop.schoolexample.repo;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.nineworanop.schoolexample.repo.entity.StudentEntity;
import com.nineworanop.schoolexample.repo.entity.querydsl.QStudentEntity;
import com.querydsl.jpa.JPQLQuery;

@Repository
public class StudentQueryRepository extends QuerydslRepositorySupport {

	public StudentQueryRepository() {
		super(StudentEntity.class);
	}

	public List<StudentEntity> findAllStudentsBySchoolId(Long schoolId) {
		QStudentEntity studentEntity = QStudentEntity.studentEntity;
		JPQLQuery<StudentEntity> jpqlQuery = from(studentEntity).where(studentEntity.schoolId.eq(schoolId));
		return jpqlQuery.fetch();
	}

}
