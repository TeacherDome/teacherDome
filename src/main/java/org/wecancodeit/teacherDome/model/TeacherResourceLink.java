package org.wecancodeit.teacherDome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class TeacherResourceLink {

	@Id
	@GeneratedValue
	private Long resourceLinkId;
	private String resourceLink;
	private Long belongsToFolderId;

	@Lob
	private String resourceLinkDescription;

	public TeacherResourceLink() {
	}

	public TeacherResourceLink(String resourceLink, String resourceLinkDescription, Long belongsToFolderId) {
		this.resourceLink = resourceLink;
		this.resourceLinkDescription = resourceLinkDescription;
		this.belongsToFolderId = belongsToFolderId;
	}

	public Long getResourceLinkId() {
		return resourceLinkId;
	}

	public String getResourceLink() {
		return resourceLink;
	}

	public String getResourceLinkDescription() {
		return resourceLinkDescription;
	}

	public Long getBelongsToFolderId() {
		return belongsToFolderId;
	}
}
