package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TaskProgress;
import com.example.demo.repository.TaskProgressRepo;
import com.example.demo.service.TaskProgressService;

@Service
public class TaskprogressServiceImpl implements TaskProgressService {
	@Autowired
	private TaskProgressRepo taskProgressRepo;
	

	@Override
	public Date getStartDate(int idTask) {
		// TODO Auto-generated method stub
		return taskProgressRepo.getStartDate(idTask);
	}

	@Override
	public Date getDeadline(int idTask) {
		// TODO Auto-generated method stub
		return taskProgressRepo.getDeadline(idTask);
	}

	@Override
	public List<TaskProgress> getListTaskProgressByIdTask(int idTask) {
		// TODO Auto-generated method stub
		return taskProgressRepo.getListTaskProgressByIdTask(idTask);
	}

	@Override
	public List<TaskProgress> findByTaskIDOrderByDateCreateAsc(int taskId) {
		// TODO Auto-generated method stub
		return taskProgressRepo.findByTaskIDOrderByDateCreateAsc(taskId);
	}

	@Override
	public TaskProgress save(TaskProgress taskProgress) {
		// TODO Auto-generated method stub
		return taskProgressRepo.save(taskProgress);
	}



}
