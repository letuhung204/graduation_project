package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author hung
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department", schema = "rangdong")
@Getter
@Setter
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iddepartment")
	private int iddepartment;

	@Column(name = "departmentname")
	private String departmentname;

	@Column(name = "departmentManeger")
	private String departmentManeger;

	@Column(name = "discription")
	private String discription;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentSet")
	private Set<Staff> staffSet;

	public int getIddepartment() {
		return iddepartment;
	}

	public void setIddepartment(int iddepartment) {
		this.iddepartment = iddepartment;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getDepartmentManeger() {
		return departmentManeger;
	}

	public void setDepartmentManeger(String departmentManeger) {
		this.departmentManeger = departmentManeger;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Set<Staff> getStaffSet() {
		return staffSet;
	}

	public void setStaffSet(Set<Staff> staffSet) {
		this.staffSet = staffSet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
