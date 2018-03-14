package com.projects.sxolion.models;

//https://www.googleapis.com/books/v1/volumes/ydQiDQAAQBAJ

public class Book {
	
	private String title;
	private String author;
	private String description;
	private String isbn;
	
	public Book() {
	}
	
	public Book(String title, String author, String desc, String isbn) {
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
