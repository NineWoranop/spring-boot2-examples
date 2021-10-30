package com.nineworanop.schoolexample.repo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nineworanop.schoolexample.dto.School;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "schools")
@Data
@SuperBuilder
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SchoolEntity extends AbstractAuditingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	private Long id;

	@Column(name = "name")
	@NonNull
	private String name;
	
	public SchoolEntity(long id, String name, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
		super(createdDate, lastModifiedDate);
		this.id = id;
		this.name = name;
	}

	public School toSchool() {
		return new School(this.id, this.name);
	}

	public static List<School> to(Iterable<SchoolEntity> list) {
		List<School> result = new ArrayList<>();
		Iterator<SchoolEntity> it = list.iterator();
		while (it.hasNext()) {
			SchoolEntity item = it.next();
			if (item != null) {
				result.add(item.toSchool());
			} else {
				result.add(null);
			}
		}
		return result;
	}

}
