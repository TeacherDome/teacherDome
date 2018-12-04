package org.wecancodeit.teacherDome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TeacherResourceFolder {

	@Id
	@GeneratedValue
	private Long resourceFolderId;
	private String resourceFolderName;

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
