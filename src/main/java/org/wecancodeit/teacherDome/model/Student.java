package org.wecancodeit.teacherDome.model;

import java.util.ArrayList;
import java.util.Collection;

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

	@Lob
	private String studentHealthNotes;

	@Lob
	private String studentFamilyNotes;

	private Collection<Integer> studentMathScores = new ArrayList<Integer>();

	public String getStudentLastName() {
		return studentLastName;
	}

	public Student() {

	}

	public Student(String studentLastName, String studentFirstName, String studentNotes, String studentSchoolIdNumber,
			ArrayList<Integer> studentMathScores, String studentHealthNotes, String studentFamilyNotes) {
		this.studentLastName = studentLastName;
		this.studentFirstName = studentFirstName;
		this.studentNotes = studentNotes;
		this.studentSchoolIdNumber = studentSchoolIdNumber;
		this.studentMathScores = studentMathScores;
		this.studentHealthNotes = studentHealthNotes;
		this.studentFamilyNotes = studentFamilyNotes;
	}

	// bare-minimum constructor
	public Student(String studentLastName, String studentFirstName, String studentSchoolIdNumber) {
		this.studentLastName = studentLastName;
		this.studentFirstName = studentFirstName;
		this.studentSchoolIdNumber = studentSchoolIdNumber;
	}

	public ArrayList<Integer> getStudentMathScores() {
		return (ArrayList<Integer>) studentMathScores;
	}

	public String getStudentHealthNotes() {
		return studentHealthNotes;
	}

	public String getStudentFamilyNotes() {
		return studentFamilyNotes;
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
