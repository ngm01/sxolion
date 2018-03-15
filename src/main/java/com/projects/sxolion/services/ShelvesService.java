package com.projects.sxolion.services;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.sxolion.models.Shelf;

@Service
public class ShelvesService {
	
	private List<Shelf> shelves = new ArrayList<Shelf>(Arrays.asList(
			new Shelf("My shelf")
			));
	
	public List<Shelf> allShelves(){
		return shelves;
	}
	
	public Shelf findShelfByIndex(int id) {
		if(id < shelves.size()) {
			return shelves.get(id);
		}
		else {
			return null;
		}
	}
	
	public void createShelf(Shelf shelf) {
		shelves.add(shelf);
	}
	
	public void updateShelf(int id, Shelf shelf) {
		if(id < shelves.size()) {
			shelves.set(id, shelf);
		}
	}
	
	public void deleteShelf(int id) {
		if(id < shelves.size()) {
			shelves.remove(id);
		}
	}
}
