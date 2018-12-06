package org.wecancodeit.teacherDome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Receipt {

	@Id
	@GeneratedValue
	private Long receiptId;

	private double cataloguedFunds;

	private String cataloguedComment;

	private double cataloguedChange;

	private String lineItem;

	public Receipt() {

	}

	public Receipt(double cataloguedFunds, String cataloguedComment) {
		this.cataloguedFunds = cataloguedFunds;
		this.cataloguedComment = cataloguedComment;
	}

	public Receipt(double cataloguedFunds, String cataloguedComment, double cataloguedChange) {
		this.cataloguedFunds = cataloguedFunds;
		this.cataloguedComment = cataloguedComment;
		this.cataloguedChange = cataloguedChange;
	}

	public double getCataloguedFunds() {
		return cataloguedFunds;
	}

	public void setCataloguedFunds(double cataloguedFunds) {
		this.cataloguedFunds = cataloguedFunds;
	}

	public String getCataloguedComment() {
		return cataloguedComment;
	}

	public String getLineItem() {
		return lineItem;
	}

	public void setLineItem(double cataloguedFunds, String cataloguedComment, double cataloguedChange,
			boolean posOrNeg) {
		if (posOrNeg == true) {
			lineItem = "+$" + cataloguedChange + " for " + cataloguedComment;
		} else {
			lineItem = "-$" + cataloguedChange + " for " + cataloguedComment;
		}
	}

	public void setCataloguedComment(String cataloguedComment) {
		this.cataloguedComment = cataloguedComment;
	}

	public double getCataloguedChange() {
		return cataloguedChange;
	}

	public void setCataloguedChange(double cataloguedChange) {
		this.cataloguedChange = cataloguedChange;
	}

}
