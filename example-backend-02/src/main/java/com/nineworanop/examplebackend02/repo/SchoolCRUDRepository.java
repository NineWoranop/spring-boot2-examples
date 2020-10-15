package com.nineworanop.examplebackend02.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nineworanop.examplebackend02.repo.entity.SchoolEntity;

public interface SchoolCRUDRepository extends CrudRepository<SchoolEntity, Long> {

	Optional<SchoolEntity> findById(Long id);

}
