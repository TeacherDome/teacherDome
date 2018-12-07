package org.wecancodeit.teacherDome.controller;

import java.util.Collection;

import javax.annotation.Resource;

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

@CrossOrigin
@RestController
public class ContactApiController {

	@Resource
	ContactRepository contactRepo;

	@GetMapping("/api/ContactPage")
	public Collection<Contact> getContacts() {
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PostMapping("/api/ContactPage/addContact")
	public Collection<Contact> addContact(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String contactFirstName = json.getString("contactFirstName");
		String contactLastName = json.getString("contactLastName");
		String contactStreet = json.getString("contactStreet");
		String contactCity = json.getString("contactCity");
		String contactState = json.getString("contactState");
		String contactZipCode = json.getString("contactZipCode");
		String contactEmail = json.getString("contactEmail");
		String contactCellPhoneNumber = json.getString("contactCellPhoneNumber");
		String contactHomePhoneNumber = json.getString("contactHomePhoneNumber");
		String contactWorkPhoneNumber = json.getString("contactWorkPhoneNumber");
		String contactPriority = json.getString("contactPriority");
		Contact contact = new Contact(contactFirstName, contactLastName, contactStreet, contactCity, contactState,
				contactZipCode, contactEmail, contactCellPhoneNumber, contactHomePhoneNumber, contactWorkPhoneNumber,
				contactPriority);
		return (Collection<Contact>) contactRepo.findAll();
	}

	@PutMapping("/api/ContactPage/updateContactFirstName")
	public Collection<Contact> updateContactFirstName(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);

		return (Collection<Contact>) contactRepo.findAll();

	}

}
