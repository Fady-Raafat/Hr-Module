package com.futuresoftware.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "USERNAME", nullable = false)
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "isENABLED")
	private boolean isEnabled;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
	List<Authority> authorityList;

	public User() {

	}

	public User(String userName, String password, boolean isEnabled) {

		this.userName = userName;
		this.password = password;
		this.isEnabled = isEnabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public List<Authority> getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List<Authority> authorityList) {
		this.authorityList = authorityList;
	}
	
// convenience method for bi-directional mapping
	
	public void addAuthority(Authority authority) {
		
		if(authorityList==null) {
			
			authorityList = new ArrayList<Authority>();

		}
		
		authorityList.add(authority);
		authority.setUser(this);
		
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", isEnabled=" + isEnabled
				+ ", authorityList=" + authorityList + "]";

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
