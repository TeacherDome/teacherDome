
package org.wecancodeit.teacherDome;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.teacherDome.model.Assignment;
import org.wecancodeit.teacherDome.model.Contact;
import org.wecancodeit.teacherDome.model.MathData;
import org.wecancodeit.teacherDome.model.ReadingData;
import org.wecancodeit.teacherDome.model.Receipt;
import org.wecancodeit.teacherDome.model.RubricElement;
import org.wecancodeit.teacherDome.model.Student;
import org.wecancodeit.teacherDome.model.TeacherResourceFolder;
import org.wecancodeit.teacherDome.model.Treasury;
import org.wecancodeit.teacherDome.repositories.AssignmentRepository;
import org.wecancodeit.teacherDome.repositories.ContactRepository;
import org.wecancodeit.teacherDome.repositories.MathDataRepository;
import org.wecancodeit.teacherDome.repositories.ReadingDataRepository;
import org.wecancodeit.teacherDome.repositories.ReceiptRepository;
import org.wecancodeit.teacherDome.repositories.RubricElementRepository;
import org.wecancodeit.teacherDome.repositories.StudentRepository;
import org.wecancodeit.teacherDome.repositories.TeacherResourceFolderRepository;
import org.wecancodeit.teacherDome.repositories.TreasuryRepository;

@Service
public class StudentPopulator implements CommandLineRunner {

	@Resource
	StudentRepository studentRepo;
	@Resource
	TeacherResourceFolderRepository folderRepo;
	@Resource
	TreasuryRepository treasureRepo;
	@Resource
	ReceiptRepository receiptRepo;

	@Resource
	MathDataRepository mathRepo;

	@Resource
	ReadingDataRepository readingRepo;

	@Resource
	ContactRepository contactRepo;

	@Resource
	AssignmentRepository assignRepo;

	@Resource
	RubricElementRepository gradeRepo;

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

		TeacherResourceFolder teacherResourceFolder1 = new TeacherResourceFolder("homework", new HashMap<>());
		teacherResourceFolder1 = folderRepo.save(teacherResourceFolder1);

		Treasury treasury1 = new Treasury(200.00);
		treasury1 = treasureRepo.save(treasury1);

		Receipt receipt1 = new Receipt(200, "This is a change", 100);
		receipt1 = receiptRepo.save(receipt1);

		mathRepo.save(new MathData("Dec 5, 2018", 400, student1));
		mathRepo.save(new MathData("Dec 6, 2018", 500, student1));
		mathRepo.save(new MathData("Dec 7, 2018", 550, student1));
		readingRepo.save(new ReadingData("Q1", 550, student1));
		readingRepo.save(new ReadingData("Q2", 555, student1));
		readingRepo.save(new ReadingData("Q3", 600, student1));

		mathRepo.save(new MathData("Week 1", 400, student2));
		mathRepo.save(new MathData("Week 2", 700, student2));
		mathRepo.save(new MathData("Week 3", 650, student2));
		mathRepo.save(new MathData("Week 4", 780, student2));
		readingRepo.save(new ReadingData("Yesterday", 550, student2));
		readingRepo.save(new ReadingData("Last Night", 800, student2));
		readingRepo.save(new ReadingData("Today", 1001, student2));

		mathRepo.save(new MathData("September", 350, student3));
		mathRepo.save(new MathData("October", 500, student3));
		mathRepo.save(new MathData("November", 1300, student3));
		readingRepo.save(new ReadingData("Aug", 550, student3));
		readingRepo.save(new ReadingData("Sept", 560, student3));
		readingRepo.save(new ReadingData("Oct", 570, student3));
		readingRepo.save(new ReadingData("Nov", 575, student3));

		contactRepo.save(new Contact("Bobby", "Fay", "dad", "123 Abc Street", "Worthington", "Ohio", "43085",
				"abc@yahoo.com", "6148888888", "6143333333", "6144444444", "Level 1", student1));
		contactRepo.save(new Contact("Abby", "Fay", "mom", "123 Abc Street", "Worthington", "Ohio", "43085",
				"abc@yahoo.com", "6148889999", "6143333333", "6144444444", "Level 1", student1));
		contactRepo.save(new Contact("Abby", "Schmoe", "mom", "123 Abc Street", "Worthington", "Ohio", "43085",
				"abc@yahoo.com", "6148888888", "6143333333", "6144444444", "Level 1", student2));

		Assignment assignment1 = new Assignment("Reading Assignment: Ella Enchanted", student1.getStudentId());
		assignment1 = assignRepo.save(assignment1);

		RubricElement grade1 = new RubricElement("Read Chapter 1 On Time", "8", "10", assignment1.getAssignmentId());
		grade1 = gradeRepo.save(grade1);

		TeacherResourceFolder teacherResourceFolder2 = new TeacherResourceFolder("home work", new HashMap<>());
		teacherResourceFolder2 = folderRepo.save(teacherResourceFolder2);

	}

	ArrayList<String> createDatesList(String[] dates) {
		return new ArrayList<>(Arrays.asList(dates));
	}

	private ArrayList<Integer> createScoreList(Integer[] scores) {
		return new ArrayList<>(Arrays.asList(scores));
	}

}
