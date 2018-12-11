package org.wecancodeit.teacherDome.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RubricElement {

	@Id
	@GeneratedValue
	private Long assignmentId;
	private String criteria;
	private String studentGrade;
	private String fullGrade;
	private Long givenAssignmentId;

	public RubricElement() {

	}

	public RubricElement(String criteria, String studentGrade, String fullGrade) {
		this.criteria = criteria;
		this.studentGrade = studentGrade;
		this.fullGrade = fullGrade;
	}

	public RubricElement(String criteria, String studentGrade, String fullGrade, Long givenAssignmentId) {
		this.criteria = criteria;
		this.studentGrade = studentGrade;
		this.fullGrade = fullGrade;
		this.givenAssignmentId = givenAssignmentId;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public String getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

	public String getFullGrade() {
		return fullGrade;
	}

	public void setFullGrade(String fullGrade) {
		this.fullGrade = fullGrade;
	}

	public Long getGivenAssignmentId() {
		return givenAssignmentId;
	}

	public void setGivenAssignmentId(Long givenAssignmentId) {
		this.givenAssignmentId = givenAssignmentId;
	}

	public Long getAssignmentId() {
		return assignmentId;
	}

}
