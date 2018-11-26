package org.wecancodeit.teacherDome.repo;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.teacherDome.model.Student;

public interface StudentRepo extends CrudRepository<Student, Long> {

}
