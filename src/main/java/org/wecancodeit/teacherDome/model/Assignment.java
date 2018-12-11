package org.wecancodeit.teacherDome.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Assignment {

	@Id
	@GeneratedValue
	private Long assignmentId;
	private String assignmentName;
	private Long givenStudentId;

	public Assignment() {

	}

	public Assignment(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public Assignment(String assignmentName, Long givenStudentId) {
		this.assignmentName = assignmentName;
		this.givenStudentId = givenStudentId;
	}

	public Long getGivenStudentId() {
		return givenStudentId;
	}

	public void setGivenStudentId(Long givenStudentId) {
		this.givenStudentId = givenStudentId;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public Long getAssignmentId() {
		return assignmentId;
	}

}
