package org.wecancodeit.teacherDome.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long studentId;
	private String studentLastName;
	private String studentFirstName;
	private String studentSchoolIdNumber;
	private boolean studentIsRetired;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "student")
	private MathData mathGrades = new MathData();

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

	public MathData getMathGrades() {
		return mathGrades;
	}

//	@JsonIgnore
//	@ManyToMany
//	private Set<Contact> contacts;

}
