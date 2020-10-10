package com.futuresoftware.service;

import java.util.List;

import com.futuresoftware.entities.User;



public interface UserService {
	
	public User insertUser(User user);
	public User updateUser(User user);
	public void deleteUserById(int id);
	public User getUserById(int id);
	public List<User> getAllUsers();
	
	public User getUserByUserName(String username);

}
