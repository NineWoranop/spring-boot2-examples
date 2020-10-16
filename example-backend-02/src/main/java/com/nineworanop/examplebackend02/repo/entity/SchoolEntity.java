package com.nineworanop.examplebackend02.repo.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nineworanop.examplebackend02.dto.School;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "schools")
@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
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
