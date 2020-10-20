package com.nineworanop.examplebackend02.repo.entity;

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

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
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
