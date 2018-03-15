package com.projects.sxolion.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projects.sxolion.models.DummyBook;
import com.projects.sxolion.services.BookService;

@Controller
public class BooksController {

	private final BookService bookService;
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/books")
	public String allBooks(Model model) {
		List<DummyBook> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "books.jsp";
	}
	
	@RequestMapping("/books{index}")
	public String singleBook(Model model, @PathVariable("index") int index) {
		DummyBook book = bookService.findBookByIndex(index);
		if(book != null) {
			model.addAttribute("book", book);
			return "singleBook.jsp";
		}
		else {
			return "books.jsp";
		}
	}
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") DummyBook book) {
		return "newBook.jsp";
	}
	
	@PostMapping("/books/new")
	public String addBook(@Valid @ModelAttribute("book") DummyBook book, BindingResult result) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		}
		else {
			bookService.addBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping("books/edit/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		DummyBook book = bookService.findBookByIndex(id);
		if(book != null) {
			model.addAttribute("book", book);
			return "editBook.jsp";
		}
		else {
			return "redirect:/books";
		}
	}
	
	@PostMapping("books/edit/{id}")
	public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") DummyBook book, BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		else {
			bookService.updateBook(id, book);
			return "redirect:/books";
		}
	}
		
	@RequestMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
}