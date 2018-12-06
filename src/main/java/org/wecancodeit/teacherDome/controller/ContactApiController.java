package org.wecancodeit.teacherDome.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}
