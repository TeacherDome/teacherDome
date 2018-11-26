package org.wecancodeit.teacherDome.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.teacherDome.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
