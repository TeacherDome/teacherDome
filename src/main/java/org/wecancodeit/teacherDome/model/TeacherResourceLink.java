package org.wecancodeit.teacherDome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class TeacherResourceLink {

	@Id
	@GeneratedValue
	private Long resourceLinkId;
	private String resourceLinkName;
	

	@Lob
	private String resourceLinkDescription;
	
	@ManyToOne
	private TeacherResourceFolder folder;

	public TeacherResourceLink() {
	}

	public TeacherResourceLink(String resourceLinkName, String resourceLinkDescription, TeacherResourceFolder folder) {
		this.resourceLinkName = resourceLinkName;
		this.resourceLinkDescription = resourceLinkDescription;
		this.folder= folder;
	}

	public TeacherResourceFolder getFolder() {
		return folder;
	}

	public Long getResourceLinkId() {
		return resourceLinkId;
	}

	public String getResourceLinkName() {
		return resourceLinkName;
	}

	public String getResourceLinkDescription() {
		return resourceLinkDescription;
	}

}
