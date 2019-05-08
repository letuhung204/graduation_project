package com.example.demo.controller;

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

import com.example.demo.entity.Feedback;
import com.example.demo.entity.Project;
import com.example.demo.service.FeedBackService;

@Controller
public class InforController {
	@Autowired
	private FeedBackService feedback;

	@GetMapping(value = "/aboutteam")
	public ModelAndView getInforTeam() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("intror/aboutteam");
		return modelAndView;
	}
	
	@GetMapping(value = "/aboutapp")
	public ModelAndView getInforWeb() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("intror/aboutapp");
		return modelAndView;
	}
	
	@GetMapping(value = "/feedback/add")
	public ModelAndView getInforWebFeedback() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("feedback",new Feedback());
		modelAndView.setViewName("intror/feedback");
		return modelAndView;
	}
	
	@RequestMapping(value = "/feedback/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("feedback") Feedback feedbacks) {

		feedback.saveFeedback(feedbacks);

		return new ModelAndView("redirect:/getfeedback");
	}
	
	@GetMapping(value = "/getfeedback")
	public ModelAndView getAllWebFeedback() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("feedbacks",feedback.listfeedBack());
		modelAndView.setViewName("intror/listfeedback");
		return modelAndView;
	}
	
	
	@GetMapping(value = "/timework")
	public ModelAndView getInfoTime() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("timework/timework");
		return modelAndView;
	}
	
}
