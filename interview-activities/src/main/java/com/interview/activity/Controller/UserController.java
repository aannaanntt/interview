package com.interview.activity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.activity.entity.User;
import com.interview.activity.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;

	@PostMapping("/addUser")
	public User saveUser(@RequestBody User user) {
		return userservice.saveUser(user);

	}

	@GetMapping("/getUser")
	public List<User> getAllUser() {
		return userservice.getUser();
	}

	@GetMapping("/getByName/{name}")
	public User getByName(@PathVariable String username) {
		return userservice.getUserByName(username);
	}
}
