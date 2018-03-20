package com.projects.sxolion.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfo {
	
	
	private String title;
	private List<String> authors;
	private String publisher;
	private String publishedDate;
	private String description;
	private List<IndustryIdentifier> industryIdentifiers;
	private long pageCount;
	private String printType;
	private List<String> categories;
	private ImageLinks imageLinks;
	private String language;
	private String previewLink;
	private String infoLink;
	private String canonicalVolumeLink;
	
	public VolumeInfo() {
	}
	
	public VolumeInfo(String title) {
		this.title = title;
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
	
	public String getSmallThumbnail(){
		return this.imageLinks.smallThumbnail;
	}
	
	public String getISBN13(){
		String ISBN13 = "978";
		for(IndustryIdentifier industryIDer: this.industryIdentifiers) {
			if(industryIDer.getType() == "ISBN_13") {
				ISBN13 = industryIDer.getIdentifier();
			}
		}
		return ISBN13;
	}
	
	public String getAuthorsAsString() {
		return stringifyListHelper(this.authors);
	}
	
	public String getCategoriesAsString() {
		return stringifyListHelper(this.categories);
	}
	
	public String stringifyListHelper(List<String> inputList) {
		String outputStr = "";
		for(int i=0;i<inputList.size();i++) {
			outputStr += inputList.get(i);
			if(i<inputList.size()-1) {
				outputStr += " , ";
			}
		}
		return outputStr;
	}

}
