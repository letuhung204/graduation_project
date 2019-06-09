package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "progress_task")
public class TaskProgress extends ObjectProgress{

	@JoinColumn(name = "task_id", referencedColumnName = "task_id")
	@ManyToOne(optional = false)
	private Task taskId;

	public Task getTaskId() {
		return taskId;
	}

	public void setTaskId(Task taskId) {
		this.taskId = taskId;
	}

}
