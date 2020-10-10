package com.futuresoftware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futuresoftware.entities.Authority;
import com.futuresoftware.repository.AuthorityRepository;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	AuthorityRepository authRepo;
	
	@Override
	public Authority insertAuthority(Authority authority) {
		return authRepo.save(authority);
	}

	@Override
	public Authority updateAuthority(Authority authority) {
		return authRepo.save(authority);
	}

	@Override
	public void deleteAuthorityById(int id) {
		
		authRepo.deleteById(id);
		
	}

	@Override
	public Authority getAuthorityById(int id) {
		return authRepo.findById(id).orElse(null);
	}

	@Override
	public List<Authority> getAllAuthorities() {
		return authRepo.findAll();
	}

}
