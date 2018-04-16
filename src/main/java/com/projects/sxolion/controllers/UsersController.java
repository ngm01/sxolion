package com.projects.sxolion.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
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

}
