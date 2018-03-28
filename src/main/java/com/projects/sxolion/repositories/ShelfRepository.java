package com.projects.sxolion.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projects.sxolion.models.Shelf;

@Repository
public interface ShelfRepository extends CrudRepository<Shelf, Long>{
	List<Shelf> findAll();
}
