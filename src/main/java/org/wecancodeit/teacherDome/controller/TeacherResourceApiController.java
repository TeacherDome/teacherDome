package org.wecancodeit.teacherDome.controller;

import java.util.Collection;
import java.util.HashMap;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.teacherDome.model.Student;
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
		TeacherResourceFolder resourceFolder = new TeacherResourceFolder(resourceFolderName,new HashMap<>());
		teacherResourceFolderRepo.save(resourceFolder);
		return (Collection<TeacherResourceFolder>) teacherResourceFolderRepo.findAll();
	}
	
	@PutMapping("/api/Folder")
	public TeacherResourceFolder getTeacherResourceFolder(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String folderIdfromBody = json.getString("folderId");
		Long resourceFolderIdLong = Long.parseLong(folderIdfromBody);
		TeacherResourceFolder folder = teacherResourceFolderRepo.findById(resourceFolderIdLong).get();
		return folder;
	}
//
//	@PostMapping("/api/TeacherResourcePage/addResourceLink")
//	public Collection<TeacherResourceLink> addResourceLink(@RequestBody String body) throws JSONException {
//		JSONObject json = new JSONObject(body);
//		String resourceLinkName = json.getString("resourceLinkName");
//		String resourceLinkDescription = json.getString("linkDescription");
//		Long belongsToFolderId = json.getLong("linkFolderId");
//		 TeacherResourceFolder folder = teacherResourceFolderRepo.findById(resourceFolderId);
//		TeacherResourceLink resourceLink = new TeacherResourceLink(resourceLinkName, resourceLinkDescription,
//				belongsToFolderId, folder);
//		teacherResourceLinkRepo.save(resourceLink);
//		return (Collection<TeacherResourceLink>) teacherResourceLinkRepo.findAll();
//	}
	
}
