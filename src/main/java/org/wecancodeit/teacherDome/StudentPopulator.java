package org.wecancodeit.teacherDome;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.teacherDome.model.Receipt;
import org.wecancodeit.teacherDome.model.Student;
import org.wecancodeit.teacherDome.model.TeacherResourceFolder;
import org.wecancodeit.teacherDome.model.Treasury;
import org.wecancodeit.teacherDome.repositories.ReceiptRepository;
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

		TeacherResourceFolder teacherResourceFolder1 = new TeacherResourceFolder("homework");
		teacherResourceFolder1 = folderRepo.save(teacherResourceFolder1);

		Treasury treasury1 = new Treasury(200.00);
		treasury1 = treasureRepo.save(treasury1);

		Receipt receipt1 = new Receipt(200, "This is a change", 100);
		receipt1 = receiptRepo.save(receipt1);
	}

}
