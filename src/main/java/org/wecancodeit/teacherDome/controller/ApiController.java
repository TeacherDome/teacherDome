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
import org.wecancodeit.teacherDome.model.Assignment;
import org.wecancodeit.teacherDome.model.MathData;
import org.wecancodeit.teacherDome.model.ReadingData;
import org.wecancodeit.teacherDome.model.Receipt;
import org.wecancodeit.teacherDome.model.RubricElement;
import org.wecancodeit.teacherDome.model.Student;
import org.wecancodeit.teacherDome.model.Treasury;
import org.wecancodeit.teacherDome.repositories.AssignmentRepository;
import org.wecancodeit.teacherDome.repositories.ContactRepository;
import org.wecancodeit.teacherDome.repositories.MathDataRepository;
import org.wecancodeit.teacherDome.repositories.ReadingDataRepository;
import org.wecancodeit.teacherDome.repositories.ReceiptRepository;
import org.wecancodeit.teacherDome.repositories.RubricElementRepository;
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

	@Resource
	AssignmentRepository assignRepo;

	@Resource
	RubricElementRepository gradesRepo;

	@GetMapping("/api/students")
	public Collection<Student> getStudents() {
		return (Collection<Student>) studentRepo.findAll();
	}

	@PutMapping("/api/math-scores")
	public Collection<MathData> getMathData(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentIdfromBody = json.getString("studentId");
		Long studentIdLong = Long.parseLong(studentIdfromBody);
		return studentRepo.findById(studentIdLong).get().getMathGrades();
	}

	@PutMapping("/api/reading-scores")
	public Collection<ReadingData> getReadingData(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentIdfromBody = json.getString("studentId");
		Long studentIdLong = Long.parseLong(studentIdfromBody);
		return studentRepo.findById(studentIdLong).get().getReadingGrades();
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

	@PutMapping("/api/students/updateStudentDateofBirth")
	public Collection<Student> updateStudentDateofBirth(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentId = json.getString("studentId");
		String studentDateOfBirth = json.getString("studentDateOfBirth");

		Long studentIdLong = Long.parseLong(studentId);
		Student student = studentRepo.findById(studentIdLong).get();

		student.setStudentDateOfBirth(studentDateOfBirth);
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

	@PutMapping("/api/students/updateStudentHealthNotes")
	public Collection<Student> updateStudentHealthNotes(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentId = json.getString("studentId");
		String studentHealthNotes = json.getString("studentHealthNotes");

		Long studentIdLong = Long.parseLong(studentId);
		Student student = studentRepo.findById(studentIdLong).get();

		student.setStudentHealthNotes(studentHealthNotes);
		studentRepo.save(student);
		return (Collection<Student>) studentRepo.findByStudentIsRetired(false);

	}

	@PutMapping("/api/students/updateStudentProgress")
	public Collection<Student> updateStudentProgress(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentId = json.getString("studentId");
		String studentProgressNotes = json.getString("studentProgressNotes");

		Long studentIdLong = Long.parseLong(studentId);
		Student student = studentRepo.findById(studentIdLong).get();

		student.setStudentProgressNotes(studentProgressNotes);
		studentRepo.save(student);
		return (Collection<Student>) studentRepo.findByStudentIsRetired(false);
	}

	@PutMapping("/api/students/updateStudentComments")
	public Collection<Student> updateStudentComments(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentId = json.getString("studentId");
		String studentComments = json.getString("studentComments");

		Long studentIdLong = Long.parseLong(studentId);
		Student student = studentRepo.findById(studentIdLong).get();

		student.setStudentComments(studentComments);
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
		Treasury treasury = treasureRepo.findById((long) 111).get();
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
		Treasury treasury = treasureRepo.findById((long) 111).get();
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

	@PostMapping("/api/student/add-math-score")
	public void addMathScore(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String date = json.getString("date");
		int score = json.getInt("score");
		String studentId = json.getString("studentId");
		Long id = Long.parseLong(studentId);
		Student studentForThisScore = studentRepo.findById(id).get();

		mathRepo.save(new MathData(date, score, studentForThisScore));
	}

	@PostMapping("/api/student/add-reading-score")
	public void addReadingScore(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String date = json.getString("date");
		int score = json.getInt("score");
		String studentId = json.getString("studentId");
		Long id = Long.parseLong(studentId);
		Student studentForThisScore = studentRepo.findById(id).get();

		readingRepo.save(new ReadingData(date, score, studentForThisScore));

	}

	// assignments
	@GetMapping("/api/assignments")
	public Collection<Assignment> getAssignments() {
		return (Collection<Assignment>) assignRepo.findAll();
	}

	@PostMapping("/api/assignments/addAssignment")
	public Collection<Assignment> addAssignment(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentId = json.getString("studentIdSent");
		String assignmentName = json.getString("assignmentNameSent");
		Long studentIdLong = Long.parseLong(studentId);

		Assignment assignemnt = new Assignment(assignmentName, studentIdLong);
		assignemnt = assignRepo.save(assignemnt);
		return (Collection<Assignment>) assignRepo.findByGivenStudentId(studentIdLong);
	}

	// grades
	@GetMapping("/api/grades")
	public Collection<RubricElement> getGrades() {
		return (Collection<RubricElement>) gradesRepo.findAll();
	}

	@PostMapping("/api/grades/addGrade")
	public Collection<RubricElement> addGrade(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String assignmentId = json.getString("assignmentId");
		String criteria = json.getString("criteriaSent");
		String studentScore = json.getString("studentScoreSent");
		String fullScore = json.getString("fullScoreSent");
		Long assignmentIdLong = Long.parseLong(assignmentId);

		RubricElement grade = new RubricElement(criteria, studentScore, fullScore, assignmentIdLong);
		grade = gradesRepo.save(grade);

		Assignment assignement = assignRepo.findById(assignmentIdLong).get();
		double studentScoreDouble = Double.parseDouble(studentScore);
		double fullScoreDouble = Double.parseDouble(fullScore);

		assignement.setTotalStudentGrade(studentScoreDouble);
		assignement.setTotalGrade(fullScoreDouble);
		assignement = assignRepo.save(assignement);

		return (Collection<RubricElement>) gradesRepo.findByGivenAssignmentId(assignmentIdLong);
	}

}