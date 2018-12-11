package org.wecancodeit.teacherDome.controller;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.teacherDome.model.Contact;
import org.wecancodeit.teacherDome.model.Student;
import org.wecancodeit.teacherDome.repositories.ContactRepository;
import org.wecancodeit.teacherDome.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactStudentRelationshipTest {

	@Resource
	private StudentRepository studentRepo;

	@Resource
	private ContactRepository contactRepo;

	@Resource
	private TestEntityManager entityManager;

	@Test
	public void shouldContainContactsForStudent() {
		Student testStudent = new Student("Molly", "Brown", "123ff", false);
		studentRepo.save(testStudent);
		Contact testContact = new Contact("Bobby", "Fay", "mom", "123 Abc Street", "Worthington", "Ohio", "43085",
				"abc@yahoo.com", "6148888888", "", "", "1", testStudent);
		contactRepo.save(testContact);
		Long studentId = testStudent.getStudentId();
		System.out.println(testStudent.getStudentFirstName());
		System.out.println(testContact.getContactFirstName());
		// Cleans out any mistakes in importing data when constructing new objects
		entityManager.flush();
		entityManager.clear();

		Optional<Student> result = studentRepo.findById(studentId);
		testStudent = result.get();
		System.out.println(testStudent);
		assertThat(testStudent.getContacts(), containsInAnyOrder(testContact));
	}
}
