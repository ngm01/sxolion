package com.projects.sxolion.services;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.sxolion.models.Book;
import com.projects.sxolion.models.VolumeInfo;
import com.projects.sxolion.repositories.BookRepository;

@Service
public class BookService {
	
	private BookRepository bookRepository;
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> addBooks(List<VolumeInfo> volumeInfoList) {
		List<Book> newBookList = new ArrayList<Book>();
		for(VolumeInfo volumeInfo: volumeInfoList) {
			Book book = new Book();
			book.setAuthors(volumeInfo.getAuthorsAsString());
			book.setCanonicalVolumeLink(volumeInfo.getCanonicalVolumeLink());
			book.setCategories(volumeInfo.getCategoriesAsString());
			book.setDescription(volumeInfo.getTrimDescription(volumeInfo.getDescription()));		
			book.setSmallThumbnail(volumeInfo.getSmallThumbnail());
			book.setISBN13(volumeInfo.getISBN13());
			book.setInfoLink(volumeInfo.getInfoLink());
			book.setLanguage(volumeInfo.getLanguage());
			book.setPageCount(volumeInfo.getPageCount());
			book.setPreviewLink(volumeInfo.getPreviewLink());
			book.setPrintType(volumeInfo.getPrintType());
			book.setPublishedDate(volumeInfo.getPublishedDate());
			book.setPublisher(volumeInfo.getPublisher());
			book.setTitle(volumeInfo.getTitle());
			newBookList.add(book);
			bookRepository.save(book);
		}
		return newBookList;
	}
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
//	public void deleteBook(Long id) {
//		bookRepository.delete(id);
//	}

}
