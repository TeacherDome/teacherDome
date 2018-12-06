package org.wecancodeit.teacherDome.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import net.minidev.json.annotate.JsonIgnore;

@Entity
public class Contact {

	@Id
	@GeneratedValue
	private Long contactId;
	private String contactFirstName;
	private String contactLastName;
	private String contactStreet;
	private String contactCity;
	private String contactState;
	private String contactZipCode;
	private String contactEmail;
	private String contactCellPhoneNumber;
	private String contactHomePhoneNumber;
	private String contactWorkPhoneNumber;
	private String contactPriority;

	public String getContactFirstName() {
		return contactFirstName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public String getContactStreet() {
		return contactStreet;
	}

	public String getContactCity() {
		return contactCity;
	}

	public String getContactState() {
		return contactState;
	}

	public String getContactZipCode() {
		return contactZipCode;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public String getContactCellPhoneNumber() {
		return contactCellPhoneNumber;
	}

	public String getContactHomePhoneNumber() {
		return contactHomePhoneNumber;
	}

	public String getContactWorkPhoneNumber() {
		return contactWorkPhoneNumber;
	}

	public String getContactPriority() {
		return contactPriority;
	}

	public Contact() {
	}

	public Contact(String contactFirstName, String contactLastName, String contactStreet, String contactCity,
			String contactState, String contactZipCode, String contactEmail, String contactCellPhoneNumber,
			String contactHomePhoneNumber, String contactWorkPhoneNumber, String contactPriority) {
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
		this.contactStreet = contactStreet;
		this.contactCity = contactCity;
		this.contactState = contactState;
		this.contactZipCode = contactZipCode;
		this.contactEmail = contactEmail;
		this.contactCellPhoneNumber = contactCellPhoneNumber;
		this.contactHomePhoneNumber = contactHomePhoneNumber;
		this.contactWorkPhoneNumber = contactWorkPhoneNumber;
		this.contactPriority = contactPriority;
	}

	@JsonIgnore
	@ManyToMany
	private Set<Student> reviews = new HashSet<>();

}
