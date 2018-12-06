package org.wecancodeit.teacherDome;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.teacherDome.model.MathData;
import org.wecancodeit.teacherDome.model.Student;
import org.wecancodeit.teacherDome.repositories.MathDataRepository;
import org.wecancodeit.teacherDome.repositories.StudentRepository;

@Service
public class StudentPopulator implements CommandLineRunner {

	@Resource
	StudentRepository studentRepo;

	@Resource
	MathDataRepository mathRepo;

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student("Jane", "Doe", "Who is she?", false);
		Student student2 = new Student("John", "Dew", "Who is HEEEEEEE?", false);
		Student student3 = new Student("Mark", "Anthony", "How'd he get here", false);
		Student student4 = new Student("Engima", "Jones", "You shouldn't be here", true);

		student1 = studentRepo.save(student1);
		student2 = studentRepo.save(student2);
		student3 = studentRepo.save(student3);
		student4 = studentRepo.save(student4);

		MathData math1 = new MathData("Dec 5, 2018", 400, student1);
		MathData math2 = new MathData("Dec 6, 2018", 500, student1);
		MathData math3 = new MathData("Dec 7, 2018", 550, student1);

		mathRepo.save(math1);
		mathRepo.save(math2);
		mathRepo.save(math3);

	}

}
