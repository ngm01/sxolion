package com.projects.sxolion.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleBooksAPIResponse {
	
	private String kind;
	private long totalItems;
	private List<BookItem> items;
	
	public GoogleBooksAPIResponse() {
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}

	public List<BookItem> getItems() {
		return items;
	}

	public void setItems(List<BookItem> items) {
		this.items = items;
	}

	public GoogleBooksAPIResponse(String kind, long totalItems, List<BookItem> items) {
		super();
		this.kind = kind;
		this.totalItems = totalItems;
		this.items = items;
	}

}
