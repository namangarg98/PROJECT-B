package com.example.projectdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.projectdemo.model.User;
import com.example.projectdemo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public UserService(UserRepository repo) {
	super();
	this.repo = repo;
	}

	
	public User saveMyUser(User user) {
		return repo.save(user);
	}
	
	public Iterable<User> showAllUsers() {
		return repo.findAll();
	}
	@Async
	public Iterable<User> deleteUserByUsername(String username){
		repo.deleteByUsername(username);
		return repo.findAll();
	}
	
	public User findByUsername(String username) {
		return repo.findByUsername(username);
	}
}
