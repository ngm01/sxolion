package com.projects.sxolion.services;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.google.zxing.WriterException;
import com.projects.sxolion.models.QRCodeGenerator;
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
		Optional<Shelf> findShelf = shelfRepo.findById(id);
		if(findShelf.isPresent()) {
			Shelf toDelete = findShelf.get();
			if(!toDelete.isDefaultShelf()) {
				shelfRepo.deleteById(id);
			}
		}
	}
	
	public void generateQRCode(Shelf shelf){
		String url = "https://www.google.com/search?q=" + shelf.getName();
		String imgPath = "./src/main/webapp/static/qrcodes/" + shelf.getId().toString() + ".png";
		QRCodeGenerator qrCodeGenerator = new QRCodeGenerator();
		try {
			qrCodeGenerator.generateQRCodeImage(url, 350, 350, imgPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(WriterException e) {
			e.printStackTrace();
		}
	}	
}
