package com.example.demo.entity;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "progress_task")
public class TaskProgress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "progresstaskId")
	private Long progressTaskId;

	@JoinColumn(name = "task_id", referencedColumnName = "task_id")
	@ManyToOne(optional = false)
	private Task taskId;

	@Column(name = "datelog")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date dateLog;

	@Column(name = "progress")
	private int progress;

	@Column(name = "detail_log")
	private String detailLog;

	private int confirm;

	public TaskProgress() {
		super();
	}

	public Long getProgressTaskId() {
		return progressTaskId;
	}

	public void setProgressTaskId(Long progressTaskId) {
		this.progressTaskId = progressTaskId;
	}

	public Date getDateLog() {
		return dateLog;
	}

	public void setDateLog(Date dateLog) {
		this.dateLog = dateLog;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public String getDetailLog() {
		return detailLog;
	}

	public void setDetailLog(String detailLog) {
		this.detailLog = detailLog;
	}

	public int getConfirm() {
		return confirm;
	}

	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}

	public Task getTaskId() {
		return taskId;
	}

	public void setTaskId(Task taskId) {
		this.taskId = taskId;
	}

}
