package com.projects.sxolion.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projects.sxolion.models.User;
import com.projects.sxolion.repositories.RoleRepository;
import com.projects.sxolion.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		userRepository.save(user);
	}
	
	public void saveWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		//This println works, which proves the problem is not here, or in the repo method
		//System.out.println("Testing in UserService: " + userRepository.findByEmail(email).getEmail());
		return userRepository.findByEmail(email);
	}
	
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
	
	public Long updateUser(User user) {
		userRepository.save(user);
		return user.getId();
	}
	
}


