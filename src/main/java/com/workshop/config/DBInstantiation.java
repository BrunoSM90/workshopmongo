package com.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshop.entities.User;
import com.workshop.repositories.UserRepository;

@Configuration
public class DBInstantiation implements CommandLineRunner{
	@Autowired
	private UserRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.deleteAll();
		User john = new User(null, "John Doe", "johndoe@gmail.com");
		User maria = new User(null, "Maria Brown", "mariabrown@bol.com");
		User alex = new User(null, "Alex Green", "alexgreen@gmail.com");
		
		repo.saveAll(Arrays.asList(john, maria, alex));
	}

}
