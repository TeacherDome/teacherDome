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

	private int studentMathScore;
	private int studentReadingScore;

	@Lob
	private String studentHealthNotes;

	@Lob
	private String studentFamilyNotes;

	public Student() {

	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public Student(String studentLastName, String studentFirstName, String studentNotes, String studentSchoolIdNumber,
			int studentMathScore, int studentReadingScore, String studentHealthNotes, String studentFamilyNotes) {
		this.studentLastName = studentLastName;
		this.studentFirstName = studentFirstName;
		this.studentNotes = studentNotes;
		this.studentSchoolIdNumber = studentSchoolIdNumber;
		this.studentMathScore = studentMathScore;
		this.studentReadingScore = studentReadingScore;
		this.studentHealthNotes = studentHealthNotes;
		this.studentFamilyNotes = studentFamilyNotes;
	}

	public int getStudentMathScore() {
		return studentMathScore;
	}

	public int getStudentReadingScore() {
		return studentReadingScore;
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
