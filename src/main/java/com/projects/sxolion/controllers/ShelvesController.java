package com.projects.sxolion.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projects.sxolion.models.Shelf;
import com.projects.sxolion.models.User;
import com.projects.sxolion.services.ShelfService;
import com.projects.sxolion.services.UserService;


@Controller
public class ShelvesController {

	private final ShelfService shelvesService;
	private final UserService userService;
	
	public ShelvesController(ShelfService shelvesService, UserService userService) {
		this.shelvesService = shelvesService;
		this.userService = userService;
	}
	
	@RequestMapping("/shelves")
	public String allShelves(Model model, Principal principal) {
		String email = principal.getName();
		User currentUser = userService.findByEmail(email);
		List<Shelf> shelves = currentUser.getShelves();
		model.addAttribute("shelves", shelves);
		model.addAttribute("shelf", new Shelf());
		return "shelves.jsp";
	}
	
	@RequestMapping("shelves/{id}")
	public String findShelf(Model model, @PathVariable("id") Long id, Principal principal) {
		Optional<Shelf> shelfOptional = shelvesService.readOne(id);
		if(shelfOptional.isPresent()) {
			String email = principal.getName();
			User currentUser = userService.findByEmail(email);
			List<Shelf> usersShelves = currentUser.getShelves();
			Shelf shelf = shelfOptional.get();
			if(usersShelves.contains(shelf)) {
				model.addAttribute("shelf", shelf);
				model.addAttribute("books", shelf.getBooks());
				return "singleShelf.jsp";
			}
			else {
				return "shelves.jsp";
			}
		}
		else {
			return "shelves.jsp";
		}
	}
	
//	@RequestMapping("shelves/new")
//	public String newShelf(@ModelAttribute("shelf") Shelf shelf) {
//		return "newShelf.jsp";
//	}
	
	@PostMapping("shelves/new")
	public String createShelf(@Valid @ModelAttribute("shelf") Shelf shelf, BindingResult result, Principal principal) {
		if(result.hasErrors()) {
			return "newShelf.jsp";
		}
		else {
			String email = principal.getName();
			User currentUser = userService.findByEmail(email);
			Long newShelfId = shelvesService.createShelf(shelf);
			Optional<Shelf> shelfOptional = shelvesService.readOne(newShelfId);
			if(shelfOptional.isPresent()) {
				Shelf newShelf = shelfOptional.get();
				List<Shelf> usersShelves = currentUser.getShelves();
				usersShelves.add(newShelf);
				currentUser.setShelves(usersShelves);
			}
			return "redirect:/shelves";
		}
	}
	
//	@RequestMapping("shelves/update/{id}")
//	public String editShelf(@PathVariable("id") int id, Model model) {
//		Shelf shelf = shelvesService.findShelfByIndex(id);
//		if(shelf != null) {
//			return "updateShelf.jsp";
//		}
//		else {
//			return "shelves.jsp";
//		}
//	}
	
	@PostMapping("shelves/update/{id}")
	public String updateShelf(@PathVariable("id") int id, @Valid @ModelAttribute("shelf") Shelf shelf, BindingResult result) {
		if(result.hasErrors()) {
			return "updateShelf.jsp";
		}
		else {
			shelvesService.updateShelf(shelf);
			return "redirect:/shelves";
		}
	}
	
	@RequestMapping("shelves/delete/{id}")
	public String deleteShelf(@PathVariable("id") Long id) {
		shelvesService.deleteShelf(id);
		return "redirect:/shelves";
	}
	
	
	
}
