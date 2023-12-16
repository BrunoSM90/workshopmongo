package com.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.entities.User;
import com.workshop.entities.dto.UserDTO;
import com.workshop.repositories.UserRepository;
import com.workshop.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User FromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
	
	public void delete(String id) {
		User user = findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Object not found.");
		}
		
		repo.delete(user);
	}
}
