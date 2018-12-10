package org.wecancodeit.teacherDome.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.teacherDome.model.Contact;
import org.wecancodeit.teacherDome.repositories.ContactRepository;
import org.wecancodeit.teacherDome.repositories.StudentRepository;

@CrossOrigin
@RestController
public class ContactApiController {

	@Resource
	ContactRepository contactRepo;

	@Resource
	StudentRepository studentRepo;

	@GetMapping("/api/Contacts")
	public Collection<Contact> getContacts() {
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PostMapping("/api/ContactPage/addContact")
	public Collection<Contact> addContact(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactFirstName = json.getString("contactFirstName");
		String contactLastName = json.getString("contactLastName");
		String contactRelationship = json.getString("contactRelationship");
		String contactStreet = json.getString("contactStreet");
		String contactCity = json.getString("contactCity");
		String contactState = json.getString("contactState");
		String contactZipCode = json.getString("contactZipCode");
		String contactEmail = json.getString("contactEmail");
		String contactCellPhoneNumber = json.getString("contactCellPhoneNumber");
		String contactHomePhoneNumber = json.getString("contactHomePhoneNumber");
		String contactWorkPhoneNumber = json.getString("contactWorkPhoneNumber");
		String contactPriority = json.getString("contactPriority");
		String contactStudents = json.getString("contactStudents");
		JSONArray studentsArray = json.getJSONArray("studentsArray");

		Contact contact = new Contact(contactFirstName, contactLastName, contactRelationship, contactStreet,
				contactCity, contactState, contactZipCode, contactEmail, contactCellPhoneNumber, contactHomePhoneNumber,
				contactWorkPhoneNumber, contactPriority);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactPage/updateContactFirstName")
	public Collection<Contact> updateContactFirstName(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactId = json.getString("contactId");
		String contactFirstName = json.getString("contactFirstName");

		Long contactIdLong = Long.parseLong(contactId);
		Contact contact = contactRepo.findById(contactIdLong).get();

		contact.setContactFirstName(contactFirstName);
		contactRepo.save(contact);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactPage/UpdateContactLastName")
	public Collection<Contact> updateContactLastName(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactId = json.getString("contactId");
		String contactLastName = json.getString("contactLastName");

		Long contactIdLong = Long.parseLong(contactId);
		Contact contact = contactRepo.findById(contactIdLong).get();

		contact.setContactLastName(contactLastName);
		contactRepo.save(contact);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactPage/UpdateContactRelationship")
	public Collection<Contact> updateContactRelationship(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactId = json.getString("contactId");
		String contactRelationship = json.getString("contactRelationship");

		Long contactIdLong = Long.parseLong(contactId);
		Contact contact = contactRepo.findById(contactIdLong).get();

		contact.setContactRelationship(contactRelationship);
		contactRepo.save(contact);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactPage/UpdateContactStreet")
	public Collection<Contact> updateContactStreet(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactId = json.getString("contactId");
		String contactStreet = json.getString("contactStreet");

		Long contactIdLong = Long.parseLong(contactId);
		Contact contact = contactRepo.findById(contactIdLong).get();

		contact.setContactStreet(contactStreet);
		contactRepo.save(contact);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactPage/UpdateContactCity")
	public Collection<Contact> updateContactCity(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactId = json.getString("contactId");
		String contactCity = json.getString("contactCity");

		Long contactIdLong = Long.parseLong(contactId);
		Contact contact = contactRepo.findById(contactIdLong).get();

		contact.setContactCity(contactCity);
		contactRepo.save(contact);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactPage/UpdateContactState")
	public Collection<Contact> updateContactState(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactId = json.getString("contactId");
		String contactState = json.getString("contactState");

		Long contactIdLong = Long.parseLong(contactId);
		Contact contact = contactRepo.findById(contactIdLong).get();

		contact.setContactState(contactState);
		contactRepo.save(contact);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactPage/UpdateContactZipCode")
	public Collection<Contact> updateContactZipCode(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactId = json.getString("contactId");
		String contactZipCode = json.getString("contactZipCode");

		Long contactIdLong = Long.parseLong(contactId);
		Contact contact = contactRepo.findById(contactIdLong).get();

		contact.setContactZipCode(contactZipCode);
		contactRepo.save(contact);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactPage/UpdateContactEmail")
	public Collection<Contact> updateContactEmail(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactId = json.getString("contactId");
		String contactEmail = json.getString("contactEmail");

		Long contactIdLong = Long.parseLong(contactId);
		Contact contact = contactRepo.findById(contactIdLong).get();

		contact.setContactEmail(contactEmail);
		contactRepo.save(contact);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactPage/UpdateContactCellPhoneNumber")
	public Collection<Contact> updateContactCellPhoneNumber(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactId = json.getString("contactId");
		String contactCellPhoneNumber = json.getString("contactCellPhoneNumber");

		Long contactIdLong = Long.parseLong(contactId);
		Contact contact = contactRepo.findById(contactIdLong).get();

		contact.setContactCellPhoneNumber(contactCellPhoneNumber);
		contactRepo.save(contact);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactPage/UpdateContactHomePhoneNumber")
	public Collection<Contact> updateContactHomePhoneNumber(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactId = json.getString("contactId");
		String contactHomePhoneNumber = json.getString("contactHomePhoneNumber");

		Long contactIdLong = Long.parseLong(contactId);
		Contact contact = contactRepo.findById(contactIdLong).get();

		contact.setContactHomePhoneNumber(contactHomePhoneNumber);
		contactRepo.save(contact);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactPage/UpdateContactWorkPhoneNumber")
	public Collection<Contact> updateContactWorkPhoneNumber(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactId = json.getString("contactId");
		String contactWorkPhoneNumber = json.getString("contactWorkPhoneNumber");

		Long contactIdLong = Long.parseLong(contactId);
		Contact contact = contactRepo.findById(contactIdLong).get();

		contact.setContactWorkPhoneNumber(contactWorkPhoneNumber);
		contactRepo.save(contact);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactPage/UpdateContactPriority")
	public Collection<Contact> updateContactPriority(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactId = json.getString("contactId");
		String contactPriority = json.getString("contactPriority");

		Long contactIdLong = Long.parseLong(contactId);
		Contact contact = contactRepo.findById(contactIdLong).get();

		contact.setContactPriority(contactPriority);
		contactRepo.save(contact);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactsById")
	public Collection<Contact> getContactsUsingId(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentId = json.getString("studentId");
		Long studentIdLong = Long.parseLong(studentId);
		return studentRepo.findById(studentIdLong).get().getContacts();

	}

}
