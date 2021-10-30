package com.nineworanop.schoolexample.repo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public abstract class AbstractAuditingEntity {

	@CreatedDate
	@Column(name = "created_date", updatable = false)
	@NonNull
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	@NonNull
	private LocalDateTime lastModifiedDate;

}
