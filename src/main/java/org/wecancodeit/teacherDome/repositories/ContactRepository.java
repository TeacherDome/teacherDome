package org.wecancodeit.teacherDome.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.teacherDome.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

	Collection<Contact> findAllContactsByStudent(Long studentId);
}
