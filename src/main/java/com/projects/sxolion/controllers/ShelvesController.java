package com.projects.sxolion.controllers;

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
import com.projects.sxolion.services.ShelfService;

@Controller
public class ShelvesController {

	private final ShelfService shelvesService;
	
	public ShelvesController(ShelfService shelvesService) {
		this.shelvesService = shelvesService;
	}
	
	@RequestMapping("/shelves")
	public String allShelves(Model model) {
		List<Shelf> shelves = shelvesService.readAll();
		model.addAttribute("shelves", shelves);
		model.addAttribute("shelf", new Shelf());
		return "shelves.jsp";
	}
	
	@RequestMapping("shelves/{id}")
	public String findShelf(Model model, @PathVariable("id") Long id) {
		Optional<Shelf> shelf = shelvesService.readOne(id);
		if(shelf != null) {
			model.addAttribute("shelf", shelf);
			return "singlShelf.jsp";
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
	public String createShelf(@Valid @ModelAttribute("shelf") Shelf shelf, BindingResult result) {
		if(result.hasErrors()) {
			return "newShelf.jsp";
		}
		else {
			shelvesService.createShelf(shelf);
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
