package org.wecancodeit.teacherDome.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.teacherDome.model.Student;
import org.wecancodeit.teacherDome.repositories.StudentRepository;

@Controller
public class StudentController {

	@Resource
	StudentRepository studentRepo;

	@GetMapping("students/{id}")
	public String getStudent(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("student", studentRepo.findById(id).get());
		return "student";
	}

}
