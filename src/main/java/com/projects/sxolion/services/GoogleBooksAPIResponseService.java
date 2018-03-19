package com.projects.sxolion.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.sxolion.models.BookItem;
import com.projects.sxolion.models.GoogleBooksAPIResponse;
import com.projects.sxolion.models.Book;

@Service
public class GoogleBooksAPIResponseService {
	
	private List<Book> bookList = new ArrayList<Book>();
	BookService bookService = new BookService();
	 
	public List<Book> createBooks(GoogleBooksAPIResponse googleBooksAPIResponse, String[] selectedBooks) {
		List<BookItem> items = googleBooksAPIResponse.getItems();
		for(String i: selectedBooks) {
			BookItem bookItem = items.get(Integer.parseInt(i));
			Book book = bookItem.getVolumeInfo();
			bookList.add(book);
		}
		return bookList;
	}
}
