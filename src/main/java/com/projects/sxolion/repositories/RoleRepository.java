package com.projects.sxolion.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projects.sxolion.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
}
