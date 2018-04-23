package com.projects.sxolion.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projects.sxolion.models.User;
import com.projects.sxolion.services.UserService;
import com.projects.sxolion.validators.UserValidator;

@Controller
public class UsersController {
	
	private UserService userService;
	private UserValidator userValidator;
	
	public UsersController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "registration.jsp";
	}
	
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, 
			BindingResult result, Model model) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "registration.jsp";
		}
		userService.saveWithUserRole(user);
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String login(
			@RequestParam(value="error", required=false) String error, 
			@RequestParam(value="logout", required=false) String logout, 
			Model model) {
		if(error != null) {
			model.addAttribute("errorMessage", "Invalid credentials, please try again.");
		}
		if(logout != null) {
			model.addAttribute("logoutMessage", "Logout successful, see you next time.");
		}
		return "login.jsp";
	}
	
	@RequestMapping("/")
	public String home(Principal principal, Model model) {
		String email = principal.getName();
		model.addAttribute("currentUser", userService.findByEmail(email));
		return "index.jsp";
	}
	
	@RequestMapping("/admin")
	public String adminPage(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByEmail(username));
		return "adminPage.jsp";
	}

}
