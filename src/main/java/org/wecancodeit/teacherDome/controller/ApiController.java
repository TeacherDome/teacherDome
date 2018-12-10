package org.wecancodeit.teacherDome.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.teacherDome.model.MathData;
import org.wecancodeit.teacherDome.model.ReadingData;
import org.wecancodeit.teacherDome.model.Receipt;
import org.wecancodeit.teacherDome.model.Student;
import org.wecancodeit.teacherDome.model.Treasury;
import org.wecancodeit.teacherDome.repositories.ContactRepository;
import org.wecancodeit.teacherDome.repositories.MathDataRepository;
import org.wecancodeit.teacherDome.repositories.ReadingDataRepository;
import org.wecancodeit.teacherDome.repositories.ReceiptRepository;
import org.wecancodeit.teacherDome.repositories.StudentRepository;
import org.wecancodeit.teacherDome.repositories.TreasuryRepository;

@CrossOrigin
@RestController
public class ApiController {

	@Resource
	StudentRepository studentRepo;

	@Resource
	MathDataRepository mathRepo;

	@Resource
	ReadingDataRepository readingRepo;

	@Resource
	TreasuryRepository treasureRepo;

	@Resource
	ReceiptRepository receiptsRepo;

	@Resource
	ContactRepository contactRepo;

	@GetMapping("/api/students")
	public Collection<Student> getStudents() {
		return (Collection<Student>) studentRepo.findAll();
	}

	@GetMapping("/api/math-scores")
	public Iterable<MathData> getMathData() {
		return mathRepo.findAll();
	}

	@GetMapping("/api/reading-scores")
	public Iterable<ReadingData> getReadingData() {
		return readingRepo.findAll();
	}

	@PutMapping("/api/student")
	public Student getStudent(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentIdfromBody = json.getString("studentId");
		Long studentIdLong = Long.parseLong(studentIdfromBody);
		Student student = studentRepo.findById(studentIdLong).get();
		return student;
	}

	@PostMapping("/api/students/addStudent")
	public Collection<Student> addStudent(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentFirstName = json.getString("studentFirstName");
		String studentLastName = json.getString("studentLastName");
		String studentSchoolIdNumber = json.getString("studentSchoolIdNumber");

		Student student = new Student(studentFirstName, studentLastName, studentSchoolIdNumber, false);
		studentRepo.save(student);
		return (Collection<Student>) studentRepo.findByStudentIsRetired(false);
	}

//	@RequestMapping("/api/ContactPage/{contactId}")

	@PutMapping("/api/students/retireStudent")
	public Collection<Student> retireStudent(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentId = json.getString("studentId");

		Long studentIdLong = Long.parseLong(studentId);
		Student student = studentRepo.findById(studentIdLong).get();
		student.setStudentIsRetired(true);
		studentRepo.save(student);
		return (Collection<Student>) studentRepo.findByStudentIsRetired(false);

	}

	@PutMapping("/api/students/updateStudent")
	public Collection<Student> updateStudent(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentId = json.getString("studentId");
		String studentFirstName = json.getString("studentFirstName");
		String studentLastName = json.getString("studentLastName");
		String studentSchoolIdNumber = json.getString("studentSchoolIdNumber");

		Long studentIdLong = Long.parseLong(studentId);
		Student student = studentRepo.findById(studentIdLong).get();

		student.setStudentFirstName(studentFirstName);
		student.setStudentLastName(studentLastName);
		student.setStudentSchoolIdNumber(studentSchoolIdNumber);
		studentRepo.save(student);
		return (Collection<Student>) studentRepo.findByStudentIsRetired(false);

	}

	@PutMapping("/api/students/updateStudentFirstName")
	public Collection<Student> updateStudentFirstName(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentId = json.getString("studentId");
		String studentFirstName = json.getString("studentFirstName");

		Long studentIdLong = Long.parseLong(studentId);
		Student student = studentRepo.findById(studentIdLong).get();

		student.setStudentFirstName(studentFirstName);
		studentRepo.save(student);
		return (Collection<Student>) studentRepo.findByStudentIsRetired(false);

	}

	@PutMapping("/api/students/updateStudentLastName")
	public Collection<Student> updateStudentLastName(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentId = json.getString("studentId");
		String studentLastName = json.getString("studentLastName");

		Long studentIdLong = Long.parseLong(studentId);
		Student student = studentRepo.findById(studentIdLong).get();

		student.setStudentLastName(studentLastName);
		studentRepo.save(student);
		return (Collection<Student>) studentRepo.findByStudentIsRetired(false);

	}

	@PutMapping("/api/students/updateStudentSchoolId")
	public Collection<Student> updateStudentSchoolId(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentId = json.getString("studentId");
		String studentSchoolIdNumber = json.getString("studentSchoolIdNumber");

		Long studentIdLong = Long.parseLong(studentId);
		Student student = studentRepo.findById(studentIdLong).get();

		student.setStudentSchoolIdNumber(studentSchoolIdNumber);
		studentRepo.save(student);
		return (Collection<Student>) studentRepo.findByStudentIsRetired(false);

	}

	// treasury
	@GetMapping("/api/treasury")
	public Collection<Treasury> getTreasury() {
		return (Collection<Treasury>) treasureRepo.findAll();
	}

	@PostMapping("/api/treasury/updateTreasuryAdd")
	public Collection<Treasury> updateTreasuryAdd(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String addFunds = json.getString("addFunds");
		String comment = json.getString("addComment");
		double fundDouble = Double.parseDouble(addFunds);
		Long id = (long) 10;
		Treasury treasury = treasureRepo.findById(id).get();
		double intialFunds = treasury.getFunds();
		Receipt receipt = new Receipt(intialFunds, comment, fundDouble);
		receipt.setLineItem(intialFunds, comment, fundDouble, true);
		receiptsRepo.save(receipt);
		treasury.setFunds(intialFunds + fundDouble);
		treasureRepo.save(treasury);
		return (Collection<Treasury>) treasureRepo.findAll();

	}

	@PostMapping("/api/treasury/updateTreasurySub")
	public Collection<Treasury> updateTreasurySubtract(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String addFunds = json.getString("addFunds");
		String comment = json.getString("subComment");
		double fundDouble = Double.parseDouble(addFunds);
		Long id = (long) 10;
		Treasury treasury = treasureRepo.findById(id).get();
		double intialFunds = treasury.getFunds();
		Receipt receipt = new Receipt(intialFunds, comment, fundDouble);
		receipt.setLineItem(intialFunds, comment, fundDouble, false);
		receiptsRepo.save(receipt);
		treasury.setFunds(intialFunds - fundDouble);
		treasureRepo.save(treasury);
		return (Collection<Treasury>) treasureRepo.findAll();

	}

	// receipts
	@GetMapping("/api/receipts")
	public Collection<Receipt> getReceipts() {
		return (Collection<Receipt>) receiptsRepo.findAll();
	}

	@PutMapping("/api/treasury/getReceipts")
	public Collection<Receipt> getReceipts(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		return (Collection<Receipt>) receiptsRepo.findAll();

	}

}