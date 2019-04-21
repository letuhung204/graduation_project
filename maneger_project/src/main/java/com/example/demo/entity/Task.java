package com.example.demo.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hung
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task", schema = "rangdong")
@NamedQueries({ @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
		@NamedQuery(name = "Task.findById", query = "SELECT t FROM Task t WHERE t.id = :id"),
		@NamedQuery(name = "Task.findByIdparentTask", query = "SELECT t FROM Task t WHERE t.idparentTask = :idparentTask"),
		@NamedQuery(name = "Task.findByNameAssign", query = "SELECT t FROM Task t WHERE t.nameAssign = :nameAssign"),
		@NamedQuery(name = "Task.findByTaskName", query = "SELECT t FROM Task t WHERE t.taskName = :taskName"),
		@NamedQuery(name = "Task.findByDateCreate", query = "SELECT t FROM Task t WHERE t.dateCreate = :dateCreate"),
		@NamedQuery(name = "Task.findByDateline", query = "SELECT t FROM Task t WHERE t.dateline = :dateline"),
		@NamedQuery(name = "Task.findByDateFinish", query = "SELECT t FROM Task t WHERE t.dateFinish = :dateFinish"),
		@NamedQuery(name = "Task.findByDiscription", query = "SELECT t FROM Task t WHERE t.discription = :discription"),
		@NamedQuery(name = "Task.findByTaskStatus", query = "SELECT t FROM Task t WHERE t.taskStatus = :taskStatus"),
		@NamedQuery(name = "Task.findByOutput", query = "SELECT t FROM Task t WHERE t.output = :output") })
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "idparent_task")
	private Integer idparentTask;
	@Column(name = "name_assign")
	private String nameAssign;
	@Column(name = "task_name")
	private String taskName;
	@Column(name = "date_create")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreate;
	@Column(name = "dateline")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateline;
	@Column(name = "date_finish")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFinish;
	@Column(name = "discription")
	private String discription;
	@Column(name = "task_status")
	private String taskStatus;
	@Column(name = "output")
	private String output;
	@ManyToMany(mappedBy = "taskSet")
	private Set<Staff> staffSet;
	@JoinColumn(name = "projectid", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Project projectid;

}
