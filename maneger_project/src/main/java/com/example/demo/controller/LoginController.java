package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

@Controller
public class LoginController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = { "/","/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		Account account = new Account();
		modelAndView.addObject("account", account);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid Account account, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Account accountExist = accountService.findAccountByEmail(account.getEmail());
		if (accountExist != null) {
			bindingResult.rejectValue("email", "error.email", "this is user with email name have exist in DB !");
		}

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			accountService.saveAccount(account);
			modelAndView.addObject("successfull", "User add successfull !");
			modelAndView.addObject("account", new Account());
			modelAndView.setViewName("registration");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountService.findAccountByEmail(auth.getName());
		modelAndView.addObject("accountName", "Welcome " + account.getEmail());
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("staff");
		return "redirect:/";
	}
}
