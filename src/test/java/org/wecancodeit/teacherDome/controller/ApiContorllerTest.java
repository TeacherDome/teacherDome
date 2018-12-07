package org.wecancodeit.teacherDome.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.wecancodeit.teacherDome.model.Student;
import org.wecancodeit.teacherDome.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ApiController.class)
public class ApiContorllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ApiController apiControl;

	@MockBean
	StudentRepository studentRepo;

	Student mockStudent = new Student("Mark", "Hamil", "Ab124", false);
	String exampleStudentJson = "[{\"studentLastName\":\"Hamil\",\"studentFirstName\":\"Mark\",\"studentId\":null,\"studentSchoolIdNumber\":\"Ab124\",\"studentIsRetired\":false,\"mathGrades\":{},\"readingGrades\":{}}]";

	@Test
	public void retrieveDetailsFromStudent() throws Exception {
//Make a mock collection of students
		Collection<Student> students = Collections.singleton(mockStudent);
		// Telling the method call what to return: IE: a collection of students with
		// mockStudent
		Mockito.when(apiControl.getStudents()).thenReturn(students);
		// This is where it points to the api mapping location
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/students").accept(MediaType.APPLICATION_JSON);
		// The Assert - what do we want to see?
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		// System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(exampleStudentJson, result.getResponse().getContentAsString(), false);
	}

	// Can add a student
	// @Test
	public void createNewStudent() throws Exception {
		Student mockStudent2 = new Student("Becky", "Hamil", "Ab125", false);
		String exampleStudentJson = "[{\"studentLastName\":\"Hamil\",\"studentFirstName\":\"Mark\",\"studentId\":null,\"studentSchoolIdNumber\":\"Ab124\",\"studentIsRetired\":false,\"mathGrades\":{},\"readingGrades\":{}}, {\"studentLastName\":\"Hamil\",\"studentFirstName\":\"Becky\",\"studentId\":null,\"studentSchoolIdNumber\":\"Ab124\",\"studentIsRetired\":false,\"mathGrades\":{},\"readingGrades\":{}}]";

		ArrayList<Student> studenten = new ArrayList<>();
		studenten.add(mockStudent);
		studenten.add(mockStudent2);
		Mockito.when(apiControl.addStudent(exampleStudentJson)).thenReturn(studenten);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/students/addStudent")
				.accept(MediaType.APPLICATION_JSON);
		// The Assert - what do we want to see?
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		JSONAssert.assertEquals(exampleStudentJson, result.getResponse().getContentAsString(), false);
	}
	// Can retire a student

	// Can update a student

	// Can update first name

	// Can update last name

	// Can update school id

}
