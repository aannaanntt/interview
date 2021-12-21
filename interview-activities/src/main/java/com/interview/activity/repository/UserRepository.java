package com.interview.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.interview.activity.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByName(String name);
}
