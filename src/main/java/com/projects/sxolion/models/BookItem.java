package com.projects.sxolion.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BookItem {

	private String kind;
	private String id;
	private String selfLink;
	private VolumeInfo volumeInfo;
	
	public BookItem() {
	}

	public BookItem(String kind, String id, String selfLink, VolumeInfo volumeInfo) {
		this.kind = kind;
		this.id = id;
		this.selfLink = selfLink;
		this.volumeInfo = volumeInfo;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSelfLink() {
		return selfLink;
	}

	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	public VolumeInfo getVolumeInfo() {
		return volumeInfo;
	}

	public void setVolumeInfo(VolumeInfo volumeInfo) {
		this.volumeInfo = volumeInfo;
	}
	
	
	
	
}
