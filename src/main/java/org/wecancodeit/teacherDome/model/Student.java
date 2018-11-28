package org.wecancodeit.teacherDome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	private String studentLastName;
	private String studentFirstName;

	@GeneratedValue
	@Id
	private Long studentId;
	private String studentSchoolIdNumber;
	private boolean studentIsRetired;

	public Student() {

	}

	// bare-minimum constructor
	public Student(String studentFirstName, String studentLastName, String studentSchoolIdNumber,
			boolean studentIsRetired) {
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentSchoolIdNumber = studentSchoolIdNumber;
		this.studentIsRetired = studentIsRetired;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public Long getStudentId() {
		return studentId;
	}

	public String getStudentSchoolIdNumber() {
		return studentSchoolIdNumber;
	}

	public boolean isStudentIsActive() {
		return studentIsRetired;
	}
}
