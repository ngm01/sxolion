package com.projects.sxolion.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfo {
	
	String title;
	List<String> authors;
	String publisher;
	String publishedDate;
	String description;
	List<IndustryIdentifier> industryIdentifiers;
	long pageCount;
	String printType;
	List<String> categories;
	ImageLinks imageLinks;
	String language;
	String previewLink;
	String infoLink;
	String canonicalVolumeLink;
	
	public VolumeInfo() {
	}
	
	public VolumeInfo(String title, List<String> authors, String publisher, String publishedDate, String description,
			List<IndustryIdentifier> industryIdentifiers, long pageCount, String printType, List<String> categories,
			ImageLinks imageLinks, String language, String previewLink, String infoLink, String canonicalVolumeLink) {
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.description = description;
		this.industryIdentifiers = industryIdentifiers;
		this.pageCount = pageCount;
		this.printType = printType;
		this.categories = categories;
		this.imageLinks = imageLinks;
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

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
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

	public List<IndustryIdentifier> getIndustryIdentifiers() {
		return industryIdentifiers;
	}

	public void setIndustryIdentifiers(List<IndustryIdentifier> industryIdentifiers) {
		this.industryIdentifiers = industryIdentifiers;
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

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public ImageLinks getImageLinks() {
		return imageLinks;
	}

	public void setImageLinks(ImageLinks imageLinks) {
		this.imageLinks = imageLinks;
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

}
