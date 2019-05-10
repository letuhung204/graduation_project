package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Project;
import com.example.demo.entity.Staff;
import com.example.demo.entity.Task;
import com.example.demo.service.ProjectService;
import com.example.demo.service.StaffService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private StaffService staffService;

	@GetMapping("/project")
	public String list(Model model) {
		model.addAttribute("projects", projectService.getListProject());
		return "listproject";
	}

	@GetMapping("/project/add")
	public String add(Model model) {
//		staff.setDepartmentId(departmentId);
		model.addAttribute("project", new Project());

		return "projectform";
	}

	@GetMapping("/project/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("project", projectService.getProjecByiD(id));

		return "projectform";
	}

	@RequestMapping(value = "/project/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("project") Project project) {

		projectService.saveProject(project);

		return new ModelAndView("redirect:/project");
	}

	@GetMapping("/project/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		projectService.deleteProjectById(id);
		redirect.addFlashAttribute("successMessage", "Deleted staff successfully!");
		return "redirect:/project";
	}

//	@GetMapping("/project/search")
//	public String search(@RequestParam("key") String key) {
//		List<Project> list = projectService.;
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("staffs", list);
//		return "redirect:/staff";
//	}

	@RequestMapping(value = "/project/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable int id) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("project", projectService.getProjecByiD(id));

		modelAndView.setViewName("detailproject");
		return modelAndView;
	}

	@GetMapping(value = "/project/{id}/task")
	public ModelAndView getTask(@PathVariable int id) {
		ModelAndView model = new ModelAndView();
		model.addObject("project", projectService.getProjecByiD(id));
		model.addObject("tasks", projectService.getListTaskOfProject(id));
		model.setViewName("listtaskofproject");
		return model;

	}

	@GetMapping(value = "/project/{id}/staff")
	public ModelAndView getstaff(@PathVariable int id) {
		ModelAndView model = new ModelAndView();
		model.addObject("project", projectService.getProjecByiD(id));
		model.addObject("staffs", projectService.getListStaffOfProject(id));
		model.setViewName("liststaffofproject");
		return model;

	}

	@GetMapping(value = "/project/{id}/staff/add")
	public ModelAndView addStaffProject(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("project", projectService.getProjecByiD(id));
		List<Staff> listStaff = projectService.getListStaffNotInProject(id);
		if(listStaff.isEmpty()) {
			modelAndView.setViewName("404");
			return modelAndView;
		}
		Map<Integer, String> staffs = new HashMap<>();
		listStaff.forEach(item -> staffs.put(item.getStaffId(), item.getFullName()));

		modelAndView.addObject("staffs", staffs);
		for (int i = 0; i < listStaff.size() - 1; i++) {
			modelAndView.addObject("staff", listStaff.get(i));
		}
		modelAndView.setViewName("addstaffinproject");
		return modelAndView;
	}

	@PostMapping(value = "/project/{id}/staff/{idStaff}/add")
	public String addStaffInproject(@PathVariable int id, @PathVariable int idStaff) {
		projectService.addStaffInProject(id, idStaff);
		return "redirect:/project/{id}/staff";
	}

	@GetMapping(value = "/project/{id}/progess")
	public ModelAndView progessProject(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("progessproject");
		return modelAndView;
	}

	@GetMapping(value = "/project/{id}/addtask")
	public String addTask(@PathVariable("id") int id, Model model) {
		List<Staff> listStaff = projectService.getListStaffOfProject(id);
		Map<Integer, String> staffs = new HashMap<>();
		listStaff.forEach(item -> staffs.put(item.getStaffId(), item.getFullName()));
		model.addAttribute("staffs", staffs);
		Task task = new Task();
		task.setProjectId(projectService.getProjecByiD(id));
		model.addAttribute("task", task);
		return "taskform";
	}

	@GetMapping(value = "/project/{id}/staff/{idStaff}/delete")
	public String deleteStaffInProject(@PathVariable int id, @PathVariable int idStaff) {
		projectService.deleteStaffIdInProject(idStaff, id);
		return "redirect:/project/{id}/staff";
	}
}
