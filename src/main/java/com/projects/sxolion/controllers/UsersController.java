package com.projects.sxolion.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projects.sxolion.models.User;
import com.projects.sxolion.services.UserService;

@Controller
public class UsersController {
	
	private UserService userService;
	
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "registration.jsp";
	}
	
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, 
			BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			return "registration.jsp";
		}
		userService.saveWithUserRole(user);
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}

}
