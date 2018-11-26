package org.wecancodeit.teacherDome.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wecancodeit.teacherDome.repo.StudentRepo;

@Controller
public class StudentController {

	@Resource
	StudentRepo studentRepo;

	@GetMapping("student/{id}")
	public String getDoggo(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("student", studentRepo.findById(id).get());
		return "student";

	}
}
