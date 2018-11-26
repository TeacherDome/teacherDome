package org.wecancodeit.teacherDome.repositories;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.teacherDome.model.Student;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {
	@Resource
	StudentRepository studentRepo;

	@Test
	public void shouldcontainStudent() {
		Student studentTed = studentRepo.save(new Student("Ted", "", "", ""));
		Iterable<Student> result = studentRepo.findAll();
		assertThat(result, hasItems(studentTed));
	}

}
