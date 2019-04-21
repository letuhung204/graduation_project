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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
@Table(name = "role", schema = "rangdong")

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "name")
	private String name;
	@ManyToMany(mappedBy = "roleSet")
	private Set<Account> accountSet;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Account> getAccountSet() {
		return accountSet;
	}

	public void setAccountSet(Set<Account> accountSet) {
		this.accountSet = accountSet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
