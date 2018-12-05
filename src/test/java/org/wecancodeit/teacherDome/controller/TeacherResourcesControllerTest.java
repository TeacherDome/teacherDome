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
import org.wecancodeit.teacherDome.repositories.TeacherResourceFolderRepository;
import org.wecancodeit.teacherDome.repositories.TeacherResourceLinkRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(TeacherResourceApiController.class)
public class TeacherResourcesControllerTest {

	@Autowired
	private MockMvc mock;

	@MockBean
	private TeacherResourceApiController resourceController;

	@MockBean
	TeacherResourceFolderRepository folderRepo;

	@MockBean
	TeacherResourceLinkRepository linkRepo;

	// test that we can reach /api/TeacherResourcePage via API controller
	@Test
	public void individualResourcePageIsOK() throws Exception {
		mock.perform(get("/api/TeacherResourcePage")).andExpect(status().isOk());
	}

	// Test that we can display folders in /api/TeacherResourcePage
	@Test
	public void addFoldersInRepo() throws Exception {
		TeacherResourceFolder homeWork = new TeacherResourceFolder();
		Set<TeacherResourceFolder> folders = Collections.singleton(homeWork);

		given(resourceController.getResourceFolders()).willReturn(folders);
		mock.perform(get("/api/TeacherResourcePage").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].resourceFolderName", is(homeWork.getResourceFolderName())));
	}

	// Test that we can add a folder
	@Test
	public void getLinkInResourceFolder() throws Exception {
		TeacherResourceLink link = new TeacherResourceLink();
		Set<TeacherResourceLink> links = Collections.singleton(link);

		given(resourceController.getResourceLink()).willReturn(links);
		mock.perform(get("/api/TeacherResourcePage/Link").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].resourceLinkName", is(link.getResourceLinkName())));
	}

	// test that we can add a link

}
