package com.interview.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.activity.entity.User;
import com.interview.activity.repository.UserRepository;
@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
	
	public User saveUser(User user) {
		return userrepository.save(user);
	}
	
	public List<User> getUser() {
		return userrepository.findAll();
	}
	
	public User getUserByName(String name) {
		return userrepository.findByName(name);
	}
}
