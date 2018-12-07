package org.wecancodeit.teacherDome.repositories;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.teacherDome.model.Contact;

@RunWith(SpringRunner.class)
@DataJpaTest

public class ContactRepositoryTest {
	@Resource
	ContactRepository contactRepo;

	@Test
	public void shouldcontainContact() {
		Contact contact1 = contactRepo.save(new Contact(null, "t", "contactLastName", "contactStreet", "contactCity",
				"contactState", "contactZipCode", "contactEmail", "contactCellPhoneNumber", "contactHomePhoneNumber",
				"contactWorkPhoneNumber", "contactPriority", null));
		Iterable<Contact> result = contactRepo.findAll();
		assertThat(result, hasItems(contact1));
	}

}
