package org.wecancodeit.teacherDome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Student {

	private String studentLastName;
	private String studentFirstName;

	@GeneratedValue
	@Id
	private Long studentId;

	@Lob
	private String studentNotes;

	private String studentSchoolIdNumber;

	public Student() {

	}

	public Student(String lastName, String firstName, String notes, String schoolId) {
		this.studentLastName = lastName;
		this.studentFirstName = firstName;
		this.studentNotes = notes;
		this.studentSchoolIdNumber = schoolId;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public Long getStudentId() {
		return studentId;
	}

	public String getStudentNotes() {
		return studentNotes;
	}

	public String getStudentSchoolIdNumber() {
		return studentSchoolIdNumber;
	}

}
