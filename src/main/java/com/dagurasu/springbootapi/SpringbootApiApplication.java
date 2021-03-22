package com.dagurasu.springbootapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dagurasu.springbootapi.model.User;
import com.dagurasu.springbootapi.repositories.UserRepository;

@SpringBootApplication
public class SpringbootApiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user = new User(null, "Douglas Souza", "doug", "1234");
		User user2 = new User(null, "Tony Stark", "tony", "1234");

		userRepository.saveAll(Arrays.asList(user, user2));
	}

}
