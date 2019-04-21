package com.example.demo.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author USER
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project", schema = "rangdong")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Basic(optional = false)
	@Column(name = "projectname")
	private String projectname;

	@Basic(optional = false)
	@Column(name = "datecreate")
	@Temporal(TemporalType.DATE)
	private Date datecreate;

	@Basic(optional = false)
	@Column(name = "datestart")
	@Temporal(TemporalType.DATE)
	private Date datestart;

	@Basic(optional = false)
	@Column(name = "datefinishschedule")
	@Temporal(TemporalType.DATE)
	private Date datefinishschedule;

	@Basic(optional = false)
	@Column(name = "datefinishactual")
	@Temporal(TemporalType.DATE)
	private Date datefinishactual;

	@Basic(optional = false)
	@Column(name = "projectstate")
	private String projectstate;

	@Column(name = "resulft")
	private String resulft;

	@Column(name = "discription")
	private String discription;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "projectid")
	private Set<Task> taskSet;

}
