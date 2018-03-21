package com.projects.sxolion.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.sxolion.models.BookItem;
import com.projects.sxolion.models.GoogleBooksAPIResponse;
import com.projects.sxolion.models.VolumeInfo;
import com.projects.sxolion.repositories.BookRepository;

@Service
public class GoogleBooksAPIResponseService {
	
	private List<VolumeInfo> volumeInfoList = new ArrayList<VolumeInfo>();
	private BookRepository bookRepo;
	BookService bookService = new BookService(bookRepo);
	 
	public List<VolumeInfo> getVolumeInfoList(GoogleBooksAPIResponse googleBooksAPIResponse, String[] selectedBooks) {
		List<BookItem> items = googleBooksAPIResponse.getItems();
		for(String i: selectedBooks) {
			BookItem bookItem = items.get(Integer.parseInt(i));
			VolumeInfo book = bookItem.getVolumeInfo();
			volumeInfoList.add(book);
		}
		return volumeInfoList;
	}
}
