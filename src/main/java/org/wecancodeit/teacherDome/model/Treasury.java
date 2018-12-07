package org.wecancodeit.teacherDome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Treasury {
	@Id
	@GeneratedValue
	private Long treasuryId;

	private double funds;

	private String comment;

	public Treasury() {

	}

	public Treasury(double funds, String comment) {
		this.funds = funds;
		this.comment = comment;
	}

	public Treasury(double funds) {
		this.funds = funds;
	}

	public void setFunds(double funds) {
		this.funds = funds;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getFunds() {
		return funds;
	}

	public String getComment() {
		return comment;
	}

}
