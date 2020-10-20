package com.nineworanop.examplebackend02.repo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StudentEntity extends AbstractAuditingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	private Long id;

	@Column(name = "school_id")
	@NonNull
	private Long schoolId;

	@Column(name = "name")
	@NonNull
	private String name;

	public StudentEntity(long id, long schoolId, String name, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		this.id = id;
		this.schoolId = schoolId;
		this.name = name;
	}
}
