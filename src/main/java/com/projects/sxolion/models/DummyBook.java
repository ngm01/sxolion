package com.projects.sxolion.models;

import javax.validation.constraints.Size;

//https://www.googleapis.com/books/v1/volumes/ydQiDQAAQBAJ

public class DummyBook {
	
	@Size(min=1, max=50)
	private String title;
	@Size(min=3, max=50)
	private String author;
	@Size(min=5, max=500)
	private String description;
	@Size(min=10, max=13)
	private String isbn;
	
	public DummyBook() {
	}
	
	public DummyBook(String title, String author, String desc, String isbn) {
		this.title = title;
		this.author = author;
		this.description = desc;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getisbn() {
		return isbn;
	}

	public void setisbn(String isbn) {
		this.isbn = isbn;
	}
	
}
