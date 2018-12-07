package org.wecancodeit.teacherDome.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.teacherDome.model.Contact;
import org.wecancodeit.teacherDome.repositories.ContactRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactApiController.class)
public class ContactApiControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	ContactRepository contactRepo;

	@MockBean
	ContactApiController contactApi;

	@Test
	public void canAccessContactElement() throws Exception {
		mvc.perform(get("/api/ContactPage")).andExpect(status().isOk());
	}

	@Test
	public void canViewAllContactsInRepo() throws Exception {
		Contact contact1 = new Contact();
		Set<Contact> allContacts = Collections.singleton(contact1);
		given(contactApi.getContacts()).willReturn(allContacts);
		mvc.perform(get("/api/ContactPage").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].contactLastName", is(contact1.getContactLastName())));
	}

	@Test
	public void canAddContactToRepo() throws Exception {
		Contact contact2 = new Contact("Tina", "Fay", "123 Abc Street", "Worthington", "Ohio", "43085", "abc@yahoo.com",
				"6148888888", "", "", "Level 1");

	}

}
