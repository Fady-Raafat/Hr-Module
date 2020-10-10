package com.futuresoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futuresoftware.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	public User findUserByUserName(String username);

}
