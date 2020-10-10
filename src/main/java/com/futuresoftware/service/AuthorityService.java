package com.futuresoftware.service;

import java.util.List;

import com.futuresoftware.entities.Authority;



public interface AuthorityService {

	public Authority insertAuthority(Authority authority);
	public Authority updateAuthority(Authority authority);
	public void deleteAuthorityById(int id);
	public Authority getAuthorityById(int id);
	public List<Authority> getAllAuthorities();

}
