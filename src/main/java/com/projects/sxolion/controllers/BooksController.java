package com.projects.sxolion.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.projects.sxolion.models.GoogleBooksAPIResponse;
import com.projects.sxolion.services.BookService;
import com.projects.sxolion.services.GoogleBooksAPIResponseService;
import com.projects.sxolion.models.Book;

@Controller
public class BooksController {

	private final BookService bookService;
	private GoogleBooksAPIResponse searchResults;
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	// @ModelAttribute("searchResults") GoogleBooksAPIResponse searchResults
	@RequestMapping("/books")
	public String allBooks(Model model) {
		List<Book> books = bookService.allBooks();
		if(this.searchResults==null) {
			model.addAttribute("searchResults", null);
		}
		else {
			model.addAttribute("searchResults", this.searchResults);
		}
		model.addAttribute("books", books);
		return "books.jsp";
	}
	
	@RequestMapping("/books/search")
	public String searchBooks(Model model, @RequestParam(name="query", defaultValue="") String query) {
		if(query.isEmpty()) {
			return "redirect:/books";
		}
		else {
			RestTemplate restTemplate = new RestTemplate();
			GoogleBooksAPIResponse searchResults = restTemplate.getForObject("https://www.googleapis.com/books/v1/volumes?q="+query, GoogleBooksAPIResponse.class);
			this.searchResults = searchResults;
			return "redirect:/books";
		}
	}
	
	@PostMapping("/books/add")
	public String addBooks(HttpServletRequest request) {
		if(request.getParameterValues("selectedBooks")==null) {
			return "redirect:/books";
		}
		else {
			String[] selectedBooks = request.getParameterValues("selectedBooks");
			GoogleBooksAPIResponseService gBARS = new GoogleBooksAPIResponseService();
			List<Book> updatedBookList = gBARS.createBooks(searchResults, selectedBooks);
			bookService.addBooks(updatedBookList);
			return "redirect:/books";
		}
	}
	
//	@RequestMapping("/books{index}")
//	public String singleBook(Model model, @PathVariable("index") int index) {
//		DummyBook book = bookService.findBookByIndex(index);
//		if(book != null) {
//			model.addAttribute("book", book);
//			return "singleBook.jsp";
//		}
//		else {
//			return "books.jsp";
//		}
//	}
//	
//	@RequestMapping("/books/new")
//	public String newBook(@ModelAttribute("book") DummyBook book) {
//		return "newBook.jsp";
//	}
//	
//	@PostMapping("/books/new")
//	public String addBook(@Valid @ModelAttribute("book") DummyBook book, BindingResult result) {
//		if(result.hasErrors()) {
//			return "newBook.jsp";
//		}
//		else {
//			bookService.addBook(book);
//			return "redirect:/books";
//		}
//	}
//	
//	@RequestMapping("books/edit/{id}")
//	public String editBook(@PathVariable("id") int id, Model model) {
//		DummyBook book = bookService.findBookByIndex(id);
//		if(book != null) {
//			model.addAttribute("book", book);
//			return "editBook.jsp";
//		}
//		else {
//			return "redirect:/books";
//		}
//	}
//	
//	@PostMapping("books/edit/{id}")
//	public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") DummyBook book, BindingResult result) {
//		if(result.hasErrors()) {
//			return "editBook.jsp";
//		}
//		else {
//			bookService.updateBook(id, book);
//			return "redirect:/books";
//		}
//	}
//		
//	@RequestMapping("/books/delete/{id}")
//	public String deleteBook(@PathVariable("id") int id) {
//		bookService.deleteBook(id);
//		return "redirect:/books";
//	}
	
}