package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "progress_project")
public class ProjectProgress extends ObjectProgress {
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	@ManyToOne(optional = false)
	private Project projectId;

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}
}
