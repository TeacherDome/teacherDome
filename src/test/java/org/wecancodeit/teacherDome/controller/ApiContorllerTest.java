package org.wecancodeit.teacherDome.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.teacherDome.model.TeacherResourceFolder;
import org.wecancodeit.teacherDome.model.TeacherResourceLink;
import org.wecancodeit.teacherDome.repositories.StudentRepository;
import org.wecancodeit.teacherDome.repositories.TeacherResourceLinkRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(TeacherResourceApiController.class)
public class ApiContorllerTest {

	@Autowired
	private MockMvc mock;

	@MockBean
	private ApiController apiControl;

	@MockBean
	StudentRepository studentRepo;

}
