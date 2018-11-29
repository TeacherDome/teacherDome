package org.wecancodeit.teacherDome.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.swing.text.html.HTML.Tag;

import net.minidev.json.annotate.JsonIgnore;

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
	public Student(String studentFirstName, String studentLastName, String studentSchoolIdNumber) {
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentSchoolIdNumber = studentSchoolIdNumber;
		this.studentIsRetired = false;
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
	
	@JsonIgnore
	@ManyToMany
	private Set<Contact> contacts;

	public boolean isStudentIsActive() {
		return studentIsRetired;
	}
}
