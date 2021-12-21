package com.interview.activity.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.interview.activity.entity.User;
import com.interview.activity.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userrepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
			System.out.println(name);
			User user = userrepository.findByName(name);
			if(user == null) {
				System.out.println("Hello" + user);
				
			}
		if(user.getUsername().equals(name)) {
			return  new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("Username is not correct"+" "+name);
		}
	}

}
