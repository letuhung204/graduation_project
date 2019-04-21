package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Staff;

public interface StaffService {
	List<Staff> findByUsername(String username);

	List<Staff> findAll();

	List<Staff> search(String term);

	Staff findOne(int id);

	void save(Staff staff);

	void delete(int id);
	
	String getDerpatmentName(int id);

}
