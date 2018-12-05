package org.wecancodeit.teacherDome.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.teacherDome.model.TeacherResourceFolder;
import org.wecancodeit.teacherDome.model.TeacherResourceLink;
import org.wecancodeit.teacherDome.repositories.TeacherResourceFolderRepository;
import org.wecancodeit.teacherDome.repositories.TeacherResourceLinkRepository;

@CrossOrigin
@RestController
public class TeacherResourceApiController {

	@Resource
	TeacherResourceFolderRepository teacherResourceFolderRepo;

	@Resource
	TeacherResourceLinkRepository teacherResourceLinkRepo;

	@GetMapping("/api/TeacherResourcePage")
	public Iterable<TeacherResourceFolder> getResourceFolders() {
		return teacherResourceFolderRepo.findAll();
	}

	@GetMapping("/api/TeacherResourcePage/Link")
	public Iterable<TeacherResourceLink> getResourceLink() {
		return teacherResourceLinkRepo.findAll();
	}

	@PostMapping("/api/TeacherResourcePage/addResourceFolder")
	public Collection<TeacherResourceFolder> addResourceFolder(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String resourceFolderName = json.getString("resourceFolderName");
		TeacherResourceFolder resourceFolder = new TeacherResourceFolder(resourceFolderName);
		teacherResourceFolderRepo.save(resourceFolder);
		return (Collection<TeacherResourceFolder>) teacherResourceFolderRepo.findAll();
	}

	@PostMapping("/api/TeacherResourcePage/addResourceLink")
	public Collection<TeacherResourceLink> addResourceLink(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String resourceLinkName = json.getString("resourceLinkName");
		String resourceLinkDescription = json.getString("linkDescription");
		Long belongsToFolderId = json.getLong("linkFolderId");
		TeacherResourceLink resourceLink = new TeacherResourceLink(resourceLinkName, resourceLinkDescription,
				belongsToFolderId);
		teacherResourceLinkRepo.save(resourceLink);
		return (Collection<TeacherResourceLink>) teacherResourceLinkRepo.findAll();
	}

}
