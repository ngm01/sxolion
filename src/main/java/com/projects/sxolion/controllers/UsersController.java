package com.projects.sxolion.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projects.sxolion.models.Book;
import com.projects.sxolion.models.Shelf;
import com.projects.sxolion.models.User;
import com.projects.sxolion.services.ShelfService;
import com.projects.sxolion.services.UserService;
import com.projects.sxolion.validators.UserValidator;

@Controller
public class UsersController {
	
	private UserService userService;
	private ShelfService shelfService;
	private UserValidator userValidator;
	
	public UsersController(UserService userService, UserValidator userValidator, ShelfService shelfService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.shelfService = shelfService;
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
		user.setUsername(user.getEmail());
		userService.saveWithUserRole(user);
		Shelf defaultShelf = new Shelf();
		defaultShelf.setName("Uncategorized");
		defaultShelf.setUser(user);
		defaultShelf.setDefaultShelf(true);
		//The below should be a method somewhere
		List<Shelf> usersShelves = new ArrayList<Shelf>();
		usersShelves.add(defaultShelf);
		user.setShelves(usersShelves);
		shelfService.updateShelf(defaultShelf);
		userService.updateUser(user);
		
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String login(
			@RequestParam(value="error", required=false) String error, 
			@RequestParam(value="logout", required=false) String logout, 
			Model model) {
		if(error != null) {
			System.out.println("Error: " + error);
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
		User currentUser = userService.findByEmail(email);
		//Get the list of user's shelves;
		List<Shelf> usersShelves = currentUser.getShelves();
		//then get the list of books in those shelves;
		List<Book> usersBooks = new ArrayList<Book>();
		if(usersShelves != null) {
			for(Shelf shelf: usersShelves) {
				for(Book book: shelf.getBooks()) {
					usersBooks.add(book);
				}
			}
		}
		//finally add the books to the model
		model.addAttribute("currentUser", currentUser);
		if(usersBooks != null) {
			model.addAttribute("usersBooks", usersBooks);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/admin")
	public String adminPage(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByEmail(username));
		return "adminPage.jsp";
	}
}
