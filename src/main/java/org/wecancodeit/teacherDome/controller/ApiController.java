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
import org.wecancodeit.teacherDome.model.Student;
import org.wecancodeit.teacherDome.repositories.StudentRepository;

@CrossOrigin
@RestController
public class ApiController {

	@Resource
	StudentRepository studentRepo;

	@GetMapping("/api/students")
	public Collection<Student> getStudents() {
		return (Collection<Student>) studentRepo.findAll();
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

}