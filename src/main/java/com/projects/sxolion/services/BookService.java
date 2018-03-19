package com.projects.sxolion.services;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.sxolion.models.Book;

@Service
public class BookService {
	
	private List<Book> masterBookList = new ArrayList<Book>(Arrays.asList(new Book("My book")));
	
	public void addBooks(List<Book> bookList) {
		for(Book book: bookList) {
			masterBookList.add(book);
		}
		for(Book book: bookList) {
			System.out.println("addBooks method: " + book.getTitle());
		}
	}
	
	public List<Book> allBooks(){
		for(Book book: masterBookList) {
			System.out.println("allBooks method: " + book.getTitle());
		}
		return this.masterBookList;
	}

}
