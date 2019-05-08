package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Staff;
import com.example.demo.repository.DepartmentRepo;
import com.example.demo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentRepo departmentRepo;

	@Override
	public List<Department> findAllDepartment() {
		// TODO Auto-generated method stub
		return departmentRepo.findAll();
	}

	@Override
	public Department findDepartment(String accountName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department findDepartmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteDepartment(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAmoutStaff(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Staff> getListStaffOfDepartment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
