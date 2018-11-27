package org.wecancodeit.teacherDome.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class MathScores {
	@Id
	@GeneratedValue
	private Long mathId;

	@ManyToOne
	private Student student;
	public ArrayList<MathScores> mathScores = new ArrayList<MathScores>();

	private float mathScore;

	public MathScores(Student student, ArrayList<MathScores> mathScores) {
		this.student = student;
		this.mathScores = mathScores;
	}

	public Long getMathId() {
		return mathId;
	}

	public Student getStudent() {
		return student;
	}

	public Collection<MathScores> getMathScores() {
		return mathScores;
	}

}
