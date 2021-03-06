package org.wecancodeit.teacherDome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ReadingData {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Student student;

	private String date;
	private int score;

	public ReadingData() {

	}

	public ReadingData(String date, int score, Student student) {
		this.date = date;
		this.score = score;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public Student getStudent() {
		return student;
	}

	public String getDate() {
		return date;
	}

	public int getScore() {
		return score;
	}
}
