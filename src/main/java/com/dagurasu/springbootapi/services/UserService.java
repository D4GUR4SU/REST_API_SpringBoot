package com.dagurasu.springbootapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dagurasu.springbootapi.exception.UserNotFoundException;
import com.dagurasu.springbootapi.model.User;
import com.dagurasu.springbootapi.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(
				() -> new UserNotFoundException("User not found! Id: " + id + ", Type: " + User.class.getName()));
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User update(Long id, User user) {
		
		User newUser = findById(id);
		newUser.setName(user.getName());
		newUser.setLogin(user.getLogin());
		newUser.setPassword(user.getPassword());
		
		return repository.save(newUser);
	}

	public User create(User user) {
		user.setId(null);
		return repository.save(user);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
