package org.wecancodeit.teacherDome.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.teacherDome.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	Collection<Student> findByStudentIsRetired(Boolean studentIsRetired);
}
