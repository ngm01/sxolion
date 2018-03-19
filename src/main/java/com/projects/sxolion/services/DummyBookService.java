package com.projects.sxolion.services;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.projects.sxolion.models.DummyBook;

@Service
public class DummyBookService {
	
	private List<DummyBook> books = new ArrayList<DummyBook>(Arrays.asList(
			new DummyBook("Head First Java", "Kathy Sierra", "Learning a complex new language", "9781449331443"),
			new DummyBook("The Landmark Thucydides", "Thucydides", "Chronicles two decades of war between Athens and Sparta", "9781416590873"),
			new DummyBook("Dune", "Frank Herbert", "Set on the desert planet Arrakis", "9780143111580")
			));

	public List<DummyBook> allBooks(){
		return books;
	}
	
	public DummyBook findBookByIndex(int idx) {
		if(idx < books.size()) {
			return books.get(idx);
		}
		else {
			return null;
		}
	}
	
	public void addBook(DummyBook book) {
		books.add(book);
	}
	
	public void updateBook(int id, DummyBook book) {
		if(id < books.size()){
			books.set(id, book);
		}
	}
	
	public void deleteBook(int id) {
		if(id < books.size()) {
			books.remove(id);
		}
	}
}
