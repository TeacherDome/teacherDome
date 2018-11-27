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
	private String studentSchoolIdNumber;

//	@Lob
//	private String studentNotes;
//	@Lob
//	private String studentHealthNotes;

<<<<<<< HEAD
//	@Lob
//	private String studentFamilyNotes;
//
//	private Collection<Integer> studentMathScores;
=======
	private ArrayList<Integer> studentMathScores = new ArrayList<Integer>();

	public String getStudentLastName() {
		return studentLastName;
	}
>>>>>>> 8c9efc077fa70174e45f40f8966af084d4c5547d

	public Student() {

	}

	// bare-minimum constructor
	public Student(String studentLastName, String studentFirstName, String studentSchoolIdNumber) {
		this.studentLastName = studentLastName;
		this.studentFirstName = studentFirstName;
		this.studentSchoolIdNumber = studentSchoolIdNumber;
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

	public String getStudentSchoolIdNumber() {
		return studentSchoolIdNumber;
	}

//	public Collection<Integer> getStudentMathScores() {
//		return (Collection<Integer>) studentMathScores;
//	}
//
//	public String getStudentHealthNotes() {
//		return studentHealthNotes;
//	}
//
//	public String getStudentFamilyNotes() {
//		return studentFamilyNotes;
//	}
//	public String getStudentNotes() {
//		return studentNotes;
//	}

}
