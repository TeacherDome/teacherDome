package org.wecancodeit.teacherDome.model;

import java.util.HashMap;
import java.util.Map;

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

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	private String studentSchoolIdNumber;
	private boolean studentIsRetired;
	private Map<String, Integer> mathGrades = new HashMap<String, Integer>();

	private Map<String, Integer> readingGrades = new HashMap<String, Integer>();

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

	public Map<String, Integer> getMathGrades() {
		return mathGrades;
	}

	public Map<String, Integer> getReadingGrades() {
		return readingGrades;
	}

	public void setMathGrades(Map<String, Integer> mathGrades) {
		this.mathGrades = mathGrades;
	}

	public void setReadingGrades(Map<String, Integer> readingGrades) {
		this.readingGrades = readingGrades;
	}

	public void addMathGrades(String mathDate, int mathGrade) {
		mathGrades.put(mathDate, mathGrade);
	}

	public void addReadingGrades(String readingDate, int readingGrade) {
		mathGrades.put(readingDate, readingGrade);
	}

//	@JsonIgnore
//	@ManyToMany
//	private Set<Contact> contacts;

}
