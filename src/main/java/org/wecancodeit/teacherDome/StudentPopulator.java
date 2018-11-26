package org.wecancodeit.teacherDome;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.teacherDome.model.Student;
import org.wecancodeit.teacherDome.repo.StudentRepo;

@Service
public class StudentPopulator implements CommandLineRunner {

	@Resource
	StudentRepo studentRepo;

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student("Doe", "Jane", "Who is she?", "PS147");
		Student student2 = new Student("Doe", "John", "Who is HEEEEEEE?", "PS147");
		Student student3 = new Student("Anthony", "Mark", "How'd he get here", "PS15-");

		student1 = studentRepo.save(student1);
		student2 = studentRepo.save(student2);
		student3 = studentRepo.save(student3);
	}

}
