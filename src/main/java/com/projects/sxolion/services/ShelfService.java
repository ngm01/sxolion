package com.projects.sxolion.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projects.sxolion.models.Shelf;
import com.projects.sxolion.repositories.ShelfRepository;

@Service
public class ShelfService {
	
	private ShelfRepository shelfRepo;
	
	public ShelfService(ShelfRepository shelfRepo) {
		this.shelfRepo = shelfRepo;
	}
	
	//read all
	public List<Shelf> readAll(){
		return shelfRepo.findAll();
	}
	
	//read one
	public Optional<Shelf> readOne(Long id) {
		return shelfRepo.findById(id);
	}
	
	//create
	public Long createShelf(Shelf shelf) {
		shelfRepo.save(shelf);
		return shelf.getId();
	}
	
	//update
	public void updateShelf(Shelf shelf) {
		shelf.setUpdatedAt(new Date());
		shelfRepo.save(shelf);
	}
	
	//delete
	public void deleteShelf(Long id) {
		shelfRepo.deleteById(id);
	}
}
