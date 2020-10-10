package com.futuresoftware.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

//	@Autowired
//	NoOpPasswordEncoder passwordEncoder;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/register").permitAll()
		
		.antMatchers("/").hasAnyRole("ADMIN","USER","MANAGER")
		.antMatchers("/admin").hasAnyRole("ADMIN","MANAGER")
		.antMatchers("/management").hasRole("MANAGER")
		
		.antMatchers("/applicants/**").hasAnyRole("ADMIN","USER","MANAGER")
		.antMatchers("/applicants/{id}").hasRole("MANAGER")		
		
		.and()
		
		.formLogin().loginPage("/login").loginProcessingUrl("/authenticateTheUser").permitAll()
		.and().logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
		

		http.csrf().disable();	
		


	}	

}
