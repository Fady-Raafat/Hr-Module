package com.futuresoftware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.futuresoftware.entities.User;
import com.futuresoftware.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User insertUser(User user) {
		
		String encrptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encrptedPassword);
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		String encrptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encrptedPassword);
		return userRepo.save(user);
	}

	@Override
	public void deleteUserById(int id) {
		
		userRepo.deleteById(id);
		
	}

	@Override @Secured ({"ROLE_USER"})
	public User getUserById(int id) {
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserByUserName(String username) {
		
		return userRepo.findUserByUserName(username);
	}


}
