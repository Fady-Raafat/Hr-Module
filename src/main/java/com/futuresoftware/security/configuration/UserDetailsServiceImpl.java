package com.futuresoftware.security.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.futuresoftware.entities.Authority;
import com.futuresoftware.entities.User;
import com.futuresoftware.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserService userservice;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userservice.getUserByUserName(username);
		if(user == null) System.out.println("no user found !");  // using sysouts is done to make rapid testing and illustrations only
		System.out.println(user.getPassword()+" "+user.getUserName());
		List<Authority> userAuthoritiesList = user.getAuthorityList();
		
		List<GrantedAuthority> userGrantedAuthorities = new ArrayList<GrantedAuthority>();
		
		for (Authority authorities : userAuthoritiesList) {
			
			userGrantedAuthorities.add(new SimpleGrantedAuthority(authorities.getRole()));
			
		}
		
		UserDetails userDetails = new UserDetailsImpl(user, userGrantedAuthorities);
		return userDetails;
	}

}
