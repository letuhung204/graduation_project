package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping(value = { "/department" })
	public ModelAndView getAllDepartment() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("departments", departmentService.findAllDepartment());
		modelAndView.setViewName("listdepartment");
		return modelAndView;
	}

	@GetMapping(value = { "/department/{id}/detail" })
	public ModelAndView getDepartmentById(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("department", departmentService.findDepartmentById(id));
		modelAndView.setViewName("detaildepartment");
		return modelAndView;
	}
}
