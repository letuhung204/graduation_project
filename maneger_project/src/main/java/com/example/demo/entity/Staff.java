
package com.example.demo.entity;

/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author USER
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staff", schema = "rangdong")
@Getter
@Setter
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	@NotNull
	private Integer id;
	@Column(name = "firstname", nullable = false)
	@NotNull
	private String firstname;
	@Column(name = "fullname")
	@NotNull
	private String fullname;
	@Column(name = "email")
	@Email
	@NotNull
	private String email;
	@Column(name = "sex")
	@NotNull
	private String sex;
	@Column(name = "address")
	@NotNull
	private String address;
	@NotNull
	@Column(name = "skill")
	private String skill;
	@NotNull
	@Column(name = "position")
	private String position;
	@Column(name = "telephone")
	@NotNull
	private String telephone;
	@JoinTable(name = "staff_task", joinColumns = {
			@JoinColumn(name = "staffid", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "taskid", referencedColumnName = "id") })
	@ManyToMany
	private Set<Task> taskSet;

	@JoinTable(name = "staff_department", joinColumns = {
			@JoinColumn(name = "staffid", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "departmentid", referencedColumnName = "iddepartment") })
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Department departmentSet;

	@OneToOne(mappedBy = "staffSet")
	private Account accountSet;

	public Staff(@NotNull Integer id, @NotNull String firstname, @NotNull String fullname, @Email @NotNull String email,
			@NotNull String sex, @NotNull String address, @NotNull String skill, @NotNull String position,
			@NotNull String telephone, Set<Task> taskSet, Department departmentSet, Account accountSet) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.fullname = fullname;
		this.email = email;
		this.sex = sex;
		this.address = address;
		this.skill = skill;
		this.position = position;
		this.telephone = telephone;
		this.taskSet = taskSet;
		this.departmentSet = departmentSet;
		this.accountSet = accountSet;
	}

	public Staff() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Task> getTaskSet() {
		return taskSet;
	}

	public void setTaskSet(Set<Task> taskSet) {
		this.taskSet = taskSet;
	}

	public Department getDepartmentSet() {
		return departmentSet;
	}

	public void setDepartmentSet(Department departmentSet) {
		this.departmentSet = departmentSet;
	}

	public Account getAccountSet() {
		return accountSet;
	}

	public void setAccountSet(Account accountSet) {
		this.accountSet = accountSet;
	}

}
