package com.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.entities.Post;
import com.workshop.repositories.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll() {
		repo.findAll();
	}
}
