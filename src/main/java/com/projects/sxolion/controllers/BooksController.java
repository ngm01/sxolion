package com.projects.sxolion.controllers;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

import com.projects.sxolion.models.Book;
import com.projects.sxolion.models.BookItem;
import com.projects.sxolion.models.GoogleBooksAPIResponse;
import com.projects.sxolion.models.Shelf;
import com.projects.sxolion.models.User;
import com.projects.sxolion.services.BookService;
import com.projects.sxolion.services.GoogleBooksAPIResponseService;
import com.projects.sxolion.services.ShelfService;
import com.projects.sxolion.services.UserService;
import com.projects.sxolion.models.VolumeInfo;

@Controller
public class BooksController {

	private final BookService bookService;
	private final ShelfService shelfService;
	private final UserService userService;
	private GoogleBooksAPIResponse searchResults;
	public BooksController(BookService bookService, ShelfService shelfService, UserService userService) {
		this.bookService = bookService;
		this.shelfService = shelfService;
		this.userService = userService;
	}
	
	// @ModelAttribute("searchResults") GoogleBooksAPIResponse searchResults
	@RequestMapping("/books")
	public String allBooks(Model model, Principal principal) {
		String email = principal.getName();
		User currentUser = userService.findByEmail(email);
		List<Book> books = bookService.allBooks();
		List<Shelf> shelves = currentUser.getShelves();
		if(this.searchResults==null) {
			model.addAttribute("searchResults", null);
		}
		else {
			model.addAttribute("searchResults", this.searchResults);
		}
		model.addAttribute("books", books);
		model.addAttribute("shelves", shelves);
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
			if(searchResults != null) {
				for(BookItem bookItem: searchResults.getItems()) {
					String desc = bookItem.getVolumeInfo().getDescription();
					if(desc==null) {
						desc = "None";
					}
					desc = getTrimDescription(desc);
					bookItem.getVolumeInfo().setDescription(desc);
				}
			}
			return "redirect:/books";
		}
	}
	
	@PostMapping("/books/add")
	public String addBooks(@RequestParam(value="selectedBooks") String[] selectedBooks, @RequestParam(value="shelfSelect") Long shelfSelect, Principal principal) {
		if(selectedBooks==null) {
			return "redirect:/books";
		}
		else {
			GoogleBooksAPIResponseService gBARS = new GoogleBooksAPIResponseService();
			List<VolumeInfo> volumeInfoList = gBARS.getVolumeInfoList(searchResults, selectedBooks);
			List<Book> booksToAddToShelf = bookService.addBooks(volumeInfoList);
			
			Optional<Shelf> shelfOptional = shelfService.readOne(shelfSelect);
			if(shelfOptional.isPresent()) {
				Shelf shelfToUpdate = shelfOptional.get();
				List<Book> shelfsBooks = shelfToUpdate.getBooks();
				for(Book book: booksToAddToShelf) {
					shelfsBooks.add(book);
				}
				shelfToUpdate.setBooks(shelfsBooks);
				shelfService.updateShelf(shelfToUpdate);
			}
			return "redirect:/books";
		}
	}
	
	
	public String getTrimDescription(String desc) {
		String trimDescription;
		if(desc.length()<255) {
			trimDescription = desc;
		}
		else {
	        List<String> endChars = Arrays.asList(" ", ",", ".", "!", "?");
	        int finalInt = 254;
	        char finalChar = desc.charAt(finalInt);
	        trimDescription = desc.substring(0, finalInt);
	        while(endChars.indexOf(String.valueOf(finalChar))==-1) {
	            finalInt--;
	            finalChar = desc.charAt(finalInt);
	            trimDescription = desc.substring(0, finalInt);
			}
		}
		return trimDescription;
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