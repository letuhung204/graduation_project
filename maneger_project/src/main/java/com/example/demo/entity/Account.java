package com.example.demo.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

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
@Table(name = "account", schema = "rangdong")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "email")
	@Email(message = "*hãy cung cấp email đúng định dạng")
	@NotEmpty(message = "*hãy nhập email")
	private String email;
	@Column(name = "password")
	 @Length(min = 5, message = "*mật khẩu phải lớn hơn 5 ký tự")
    @NotEmpty(message = "*Hãy nhập mật khẩu")
	private String password;
	@Column(name = "ENABLED")
	private boolean enabled;
	@JoinTable(name = "account_role", joinColumns = {
			@JoinColumn(name = "account_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id") })
	@ManyToMany
	private Set<Role> roleSet;
	@JoinTable(name = "account_staff", joinColumns = {
			@JoinColumn(name = "account_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "staff_id", referencedColumnName = "id") })
	@OneToOne
	private Staff staffSet;

	public Account(Integer id, String email, String password, boolean enabled, Set<Role> roleSet, Staff staffSet) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.roleSet = roleSet;
		this.staffSet = staffSet;
	}

	public Account() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	public Staff getStaffSet() {
		return staffSet;
	}

	public void setStaffSet(Staff staffSet) {
		this.staffSet = staffSet;
	}

}
