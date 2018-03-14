package com.projects.sxolion.services;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.projects.sxolion.models.Book;

@Service
public class BookService {
	
	private List<Book> books = new ArrayList<Book>(Arrays.asList(
			new Book("Head First Java", "Kathy Sierra", "Learning a complex new language", "9781449331443"),
			new Book("The Landmark Thucydides", "Thucydides", "Chronicles two decades of war between Athens and Sparta", "9781416590873"),
			new Book("Dune", "Frank Herbert", "Set on the desert planet Arrakis", "9780143111580")
			));

	public List<Book> allBooks(){
		return books;
	}
	
	public Book findBookByIndex(int idx) {
		if(idx < books.size()) {
			return books.get(idx);
		}
		else {
			return null;
		}
	}
}
