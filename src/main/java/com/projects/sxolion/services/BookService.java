package com.projects.sxolion.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.sxolion.models.Book;
import com.projects.sxolion.models.VolumeInfo;

@Service
public class BookService {
	
	private List<Book> masterBookList = new ArrayList<Book>();
	
	public void addBooks(List<VolumeInfo> volumeInfoList) {
		for(VolumeInfo volumeInfo: volumeInfoList) {
			Book book = new Book();
			book.setAuthors(volumeInfo.getAuthors());
			book.setCanonicalVolumeLink(volumeInfo.getCanonicalVolumeLink());
			book.setCategories(volumeInfo.getCategories());
			book.setDescription(volumeInfo.getDescription());
			
			//These two need special helper methods:
			book.setImageLinks(volumeInfo.convertImageLinks());
			book.setIndustryIdentifiers(volumeInfo.convertIndustryIdentifiers());
			
			book.setInfoLink(volumeInfo.getInfoLink());
			book.setLanguage(volumeInfo.getLanguage());
			book.setPageCount(volumeInfo.getPageCount());
			book.setPreviewLink(volumeInfo.getPreviewLink());
			book.setPrintType(volumeInfo.getPrintType());
			book.setPublishedDate(volumeInfo.getPublishedDate());
			book.setPublisher(volumeInfo.getPublisher());
			book.setTitle(volumeInfo.getTitle());
			masterBookList.add(book);
		}
	}
	
	public List<Book> allBooks(){
		return this.masterBookList;
	}

}
