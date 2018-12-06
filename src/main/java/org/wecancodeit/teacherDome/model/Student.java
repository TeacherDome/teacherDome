package org.wecancodeit.teacherDome.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long studentId;
	private String studentLastName;
	private String studentFirstName;
	private String studentSchoolIdNumber;
	private boolean studentIsRetired;

	@OneToMany(mappedBy = "student")
	public Collection<MathData> mathGrades;

	public Student() {

	}

	// bare-minimum constructor
	public Student(String studentFirstName, String studentLastName, String studentSchoolIdNumber,
			boolean studentIsRetired) {
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentSchoolIdNumber = studentSchoolIdNumber;
		this.studentIsRetired = false;
	}

	public void setStudentIsRetired(boolean studentIsRetired) {
		this.studentIsRetired = studentIsRetired;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public void setStudentSchoolIdNumber(String studentSchoolIdNumber) {
		this.studentSchoolIdNumber = studentSchoolIdNumber;
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

	public boolean isStudentIsRetired() {
		return studentIsRetired;
	}

	public Collection<MathData> getMathGrades() {
		return mathGrades;
	}

	public void addMathScore(MathData score) {
		mathGrades.add(score);
	}

//	@JsonIgnore
//	@ManyToMany
//	private Set<Contact> contacts;

}
