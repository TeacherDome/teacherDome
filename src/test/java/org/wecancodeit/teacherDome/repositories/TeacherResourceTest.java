package org.wecancodeit.teacherDome.repositories;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.teacherDome.model.TeacherResourceFolder;
import org.wecancodeit.teacherDome.model.TeacherResourceLink;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TeacherResourceTest {

	@Resource
	TeacherResourceLinkRepository linkRepo;

	@Resource
	TeacherResourceFolderRepository folderRepo;

	@Test
	public void shouldContainLink() {
		TeacherResourceLink linkOne = linkRepo.save(new TeacherResourceLink("www.yahoo.com", "Yahoo!", null));
		Iterable<TeacherResourceLink> result = linkRepo.findAll();
		assertThat(result, hasItems(linkOne));
	}

	@Test
	public void shouldContainFolder() {
		TeacherResourceFolder folderOne = folderRepo.save(new TeacherResourceFolder("Things"));
		Iterable<TeacherResourceFolder> result = folderRepo.findAll();
		assertThat(result, hasItems(folderOne));
	}
}
