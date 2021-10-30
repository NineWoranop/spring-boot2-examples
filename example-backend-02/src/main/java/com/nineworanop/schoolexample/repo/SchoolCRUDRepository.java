package com.nineworanop.schoolexample.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nineworanop.schoolexample.repo.entity.SchoolEntity;

@Repository
public interface SchoolCRUDRepository extends CrudRepository<SchoolEntity, Long> {

	Optional<SchoolEntity> findById(Long id);

}
