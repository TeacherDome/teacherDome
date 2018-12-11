package org.wecancodeit.teacherDome.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.teacherDome.model.Assignment;
import org.wecancodeit.teacherDome.model.Student;

public interface AssignmentRepository extends CrudRepository<Assignment, Long> {
	Collection<Assignment> findByGivenStudentId(Long givenStudentId);
}
