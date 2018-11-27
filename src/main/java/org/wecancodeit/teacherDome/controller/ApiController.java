package org.wecancodeit.teacherDome.controller;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public void addStudent(String studentFirstName, String studentLastName, String studentstudentSchoolIdNumber) {
		studentRepo.save(new Student(studentFirstName, studentLastName, studentstudentSchoolIdNumber));
	}

}
