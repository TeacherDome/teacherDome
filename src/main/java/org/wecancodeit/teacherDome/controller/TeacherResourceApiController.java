package org.wecancodeit.teacherDome.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.teacherDome.repositories.TeacherResourceFolderRepository;
import org.wecancodeit.teacherDome.repositories.TeacherResourceLinkRepository;

@CrossOrigin
@RestController
public class TeacherResourceApiController {

	@Resource
	TeacherResourceFolderRepository teacherResourceFolderRepo;

	@Resource
	TeacherResourceLinkRepository teacherResourceLinkRepo;

}
