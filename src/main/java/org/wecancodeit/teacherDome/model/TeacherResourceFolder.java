package org.wecancodeit.teacherDome.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TeacherResourceFolder {

	@Id
	@GeneratedValue
	private Long resourceFolderId;
	private String resourceFolderName;
	
	@OneToMany
	Map<String, TeacherResourceLink> links = new HashMap<String,TeacherResourceLink>();

	public TeacherResourceFolder() {

	}

	public TeacherResourceFolder(String resourceFolderName) {
		this.resourceFolderName = resourceFolderName;
	}

	public Long getResourceFolderId() {
		return resourceFolderId;
	}

	public String getResourceFolderName() {
		return resourceFolderName;
	}

}
