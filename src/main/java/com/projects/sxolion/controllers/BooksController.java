package com.projects.sxolion.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projects.sxolion.models.Book;
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
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "books.jsp";
	}
	
	@RequestMapping("/books{index}")
	public String singleBook(Model model, @PathVariable("index") int index) {
		Book book = bookService.findBookByIndex(index);
		model.addAttribute("book", book);
		return "singleBook.jsp";
		
	}
	
}