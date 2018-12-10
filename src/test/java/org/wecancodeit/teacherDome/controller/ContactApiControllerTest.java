package org.wecancodeit.teacherDome.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.wecancodeit.teacherDome.model.Contact;
import org.wecancodeit.teacherDome.repositories.ContactRepository;
import org.wecancodeit.teacherDome.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactApiController.class)
public class ContactApiControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	ContactRepository contactRepo;

	@MockBean
	ContactApiController contactApi;

	@MockBean
	StudentRepository studentRepo;

	Contact mockContact = new Contact("Bobby", "Fay", "mom", "123 Abc Street", "Worthington", "Ohio", "43085",
			"abc@yahoo.com", "6148888888", "", "", "Level 1");
	String exampleContactJson = "[{\"contactId\":\"13\", \"contactFirstName\":\"Bobby\", \"contactLastName\":\"Fay\", \"contactStreet\":\"123 Abc Street\", \"contactCity\":\"Worthington\", \"contactState\":\"Ohio\", \"contactZipCode\":\"43085\", \"contactEmail\":\"abc@yahool.com\", \"contactCellPhoneNumber\":\"6148888888\", \"contactHomePhoneNumber\":\"\", \"contactWorkPhoneNumber\":\"\", \"conatctPriority\":\"Level 1\"}]";

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
		Contact contact2 = new Contact("Tina", "Fay", "mom", "123 Abc Street", "Worthington", "Ohio", "43085",
				"abc@yahoo.com", "6148888888", "", "", "Level 1");
		Mockito.when(contactRepo.save(Mockito.any(Contact.class))).thenReturn(contact2);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/ContactPage/addContact")
				.accept(MediaType.APPLICATION_JSON).content(exampleContactJson).contentType(MediaType.APPLICATION_JSON);
		// Get Http Response Value
		MockHttpServletResponse response = mvc.perform(requestBuilder).andReturn().getResponse();

		// Assert that you get a 2xx level response
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	@Test
	public void canUpdateContactFirstName() throws Exception {

	}

}
