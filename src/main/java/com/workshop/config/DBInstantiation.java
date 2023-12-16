package com.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshop.entities.Post;
import com.workshop.entities.User;
import com.workshop.repositories.PostRepository;
import com.workshop.repositories.UserRepository;

@Configuration
public class DBInstantiation implements CommandLineRunner{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		userRepo.deleteAll();
		postRepo.deleteAll();
		
		User john = new User(null, "John Doe", "johndoe@gmail.com");
		User maria = new User(null, "Maria Brown", "mariabrown@bol.com");
		User alex = new User(null, "Alex Green", "alexgreen@gmail.com");
		
		userRepo.saveAll(Arrays.asList(john, maria, alex));
		
		Post p1 = new Post(null, Instant.now(), "Viagem para Mendoza", "foi muito legal", john);
		Post p2 = new Post(null, Instant.now(), "Prainha no sábado", "calorao af", maria);
		Post p3 = new Post(null, Instant.now(), "Jantarzinho com mozão", "yummy tummy", john);
		
		postRepo.saveAll(Arrays.asList(p1, p2, p3));
	}

}
