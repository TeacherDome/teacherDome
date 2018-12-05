package org.wecancodeit.teacherDome.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MathData {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private Student student;

	private ArrayList<String> dates = new ArrayList<String>();
	private ArrayList<Integer> scores = new ArrayList<Integer>();

	public MathData() {

	}

	public ArrayList<String> getDates() {
		return dates;
	}

	public ArrayList<Integer> getScores() {
		return scores;
	}
}
