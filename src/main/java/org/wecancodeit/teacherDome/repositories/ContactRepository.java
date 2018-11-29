package org.wecancodeit.teacherDome.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.teacherDome.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
