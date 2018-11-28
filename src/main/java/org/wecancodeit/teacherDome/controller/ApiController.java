package org.wecancodeit.teacherDome.controller;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Iterable<Student> getStudent() {
		return studentRepo.findAll();
	}

	@PostMapping("/api/students/addStudent")
	public void addStudent(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String studentFirstName = json.getString("studentFirstName");
		String studentLastName = json.getString("studentLastName");
		String studentSchoolIdNumber = json.getString("studentSchoolIdNumber");

		Student student = new Student(studentFirstName, studentLastName, studentSchoolIdNumber);
		studentRepo.save(student);

	}

}