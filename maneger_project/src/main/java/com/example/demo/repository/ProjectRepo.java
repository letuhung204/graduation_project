package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Project;
@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer>{
	
//	public Project findByUsename(String projectname);
}
