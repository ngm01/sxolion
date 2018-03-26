package com.projects.sxolion.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String title;
	@Column
	private String authors;
	@Column
	private String publisher;
	@Column
	private String publishedDate;
	@Lob
	@Column
	private String description;
	@Column
	private String ISBN13;
	@Column
	private long pageCount;
	@Column
	private String printType;
	@Column
	private String categories;
	@Column
	private String smallThumbnail;
	@Column
	private String language;
	@Column
	private String previewLink;
	@Column
	private String infoLink;
	@Column
	private String canonicalVolumeLink;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM/dd/yyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM/dd/yyy HH:mm:ss")
	private Date updatedAt;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="books_shelves",
		joinColumns=@JoinColumn(name="book_id"),
		inverseJoinColumns=@JoinColumn(name="shelf_id")
	)
	private List<Shelf> shelves;
	
	public Book() {
	}
	
	public Book(String title) {
		this.title = title;
	}
	
	public Book(String title, String authors, String publisher, String publishedDate, String description,
			String ISBN13, long pageCount, String printType, String categories,
			String smallThumbnail, String language, String previewLink, String infoLink, String canonicalVolumeLink) {
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.description = description;
		this.ISBN13 = ISBN13;
		this.pageCount = pageCount;
		this.printType = printType;
		this.categories = categories;
		this.smallThumbnail = smallThumbnail;
		this.language = language;
		this.previewLink = previewLink;
		this.infoLink = infoLink;
		this.canonicalVolumeLink = canonicalVolumeLink;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getISBN13() {
		return ISBN13;
	}

	public void setISBN13(String ISBN13) {
		this.ISBN13 = ISBN13;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public String getPrintType() {
		return printType;
	}

	public void setPrintType(String printType) {
		this.printType = printType;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getSmallThumbnail() {
		return smallThumbnail;
	}

	public void setSmallThumbnail(String smallThumbnail) {
		this.smallThumbnail = smallThumbnail;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPreviewLink() {
		return previewLink;
	}

	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}

	public String getInfoLink() {
		return infoLink;
	}

	public void setInfoLink(String infoLink) {
		this.infoLink = infoLink;
	}

	public String getCanonicalVolumeLink() {
		return canonicalVolumeLink;
	}

	public void setCanonicalVolumeLink(String canonicalVolumeLink) {
		this.canonicalVolumeLink = canonicalVolumeLink;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
