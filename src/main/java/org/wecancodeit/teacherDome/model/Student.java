package org.wecancodeit.teacherDome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Student {

	private String lastName;
	private String firstName;

	@GeneratedValue
	@Id
	private Long id;

	@Lob
	private String notes;

	private String schoolId;

	public Student() {

	}

	public Student(String lastName, String firstName, String notes, String schoolId) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.notes = notes;
		this.schoolId = schoolId;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public Long getId() {
		return id;
	}

	public String getNotes() {
		return notes;
	}

	public String getSchoolId() {
		return schoolId;
	}

}
