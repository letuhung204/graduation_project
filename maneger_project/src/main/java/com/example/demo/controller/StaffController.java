package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Staff;
import com.example.demo.service.StaffService;

@Controller
public class StaffController {
	@Autowired
	private StaffService staffService;

	// @Autowired
	// private SercurityService sercurityService;

//  @Autowired
//  private StaffValidator staffValidator;

	// @GetMapping("/register")
	// public String registration(Model model) {
	// model.addAttribute("staffForm", new Staff());
	// return "register";
	// }
	//
	// @PostMapping("/register")
	// public String registration(@ModelAttribute("staffForm") Staff staffForm,
	// BindingResult
	// bindingResult) {
	// staffValidator.validate(staffForm, bindingResult);
	//
	// if (bindingResult.hasErrors()) {
	// return "register";
	// }
	//
	// staffService.save(staffForm);
	//
	//// sercurityService.autoLogin(staffForm.getUsename(),
	// staffForm.getPassword());
	//
	// return "redirect:/welcome";
	// }
	//
	// @GetMapping("/login")
	// public String login(Model model, String error, String logout) {
	// if (error != null)
	// model.addAttribute("error", "Your username and password is invalid.");
	//
	// if (logout != null)
	// model.addAttribute("message", "You have been logged out successfully.");
	//
	// return "login";
	// }
//
	@GetMapping({ "/", "/welcome" })
	public String welcome(Model model) {
		return "welcome";
	}

	@GetMapping("/staff")
	public String list(Model model) {
		model.addAttribute("staffs", staffService.findAll());
		return "liststaff";
	}

	@GetMapping("/staff/add")
	public String add(Model model) {
		model.addAttribute("staff", new Staff());
		return "staffform";
	}

	@GetMapping("/staff/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("staff", staffService.findOne(id));
		return "staffform";
	}

	@PostMapping("/staff/save")
	public ModelAndView save(@ModelAttribute("staff") Staff staff) {
		staffService.save(staff);
		return new ModelAndView("redirect:/staff");
	}

	@GetMapping("/staff/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		staffService.delete(id);
		redirect.addFlashAttribute("successMessage", "Deleted staff successfully!");
		return "redirect:/staff";
	}

	@GetMapping("/staff/search")
	public String search(@RequestParam("term") String term, Model model) {
		if (StringUtils.isEmpty(term)) {
			return "redirect:/staff";
		}

		model.addAttribute("staff", staffService.search(term));
		return "liststaff";
	}
}
