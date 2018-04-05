package com.projects.sxolion.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projects.sxolion.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findUserByEmail(String email);
}
