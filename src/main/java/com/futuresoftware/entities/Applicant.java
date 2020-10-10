package com.futuresoftware.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Past;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.futuresoftware.service.ApplicantService;

import lombok.ToString;

@Entity
@Table(name="applicant")
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Applicant{
	
	@Transient @JsonIgnore
	private boolean isDateNotValid;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	
	@Column(name="password")
	private String password;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="email")
	private String eMail;
	
	@Column(name="address")
	private String address;
	
	@Past(message = "invalid date")
	@Temporal(TemporalType.DATE)
	@Column(name="birthdate")
	private Date birthDate;
	
	@Lob
	@Column(name="cv")
	private byte[] cv;

	@Column(name="mobileno")
	private String mobileNo;
	
	@Column(name="gender")
	private String gender;
	

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name = "job_id")
	 AvailableJob availableJob;
	
	
	
//	public Applicant(String username, String password, String firstName,
//			String lastName, String eMail, String address, Date birthDate, String mobileNo,
//			String gender, byte[] cv) {
//		
//		this.username = username;
//		this.password = password;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.eMail = eMail;
//		this.address = address;
//		this.cv = cv;
//		this.mobileNo = mobileNo;
//		this.gender = gender;
//		this.birthDate = birthDate;
//		
//	}
	
	
	public Applicant() {

	
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		
	
			this.username = username;
			
	
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		
		
		
		if(password.length()<6) {
			
			this.password = "";
			
			
		} else {
			
			
			this.password = password;
		}
		
		
		
		
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		
		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		
		if(eMail.matches(regex)) {
			
			this.eMail = eMail;
			
		} else {
			
			this.eMail = "";
			
		} 

		
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate)  {
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			this.birthDate = sdf.parse(birthDate);
			
			
		} catch (ParseException e) {
	
			isDateNotValid = true;

		}
		
		
	}
	
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

	public AvailableJob getAvailableJob() {
		return availableJob;
	}


	public void setAvailableJob(AvailableJob availableJob) {
		this.availableJob = availableJob;
	}


	public byte[] getCv() {
		return cv;
	}


	public void setCv(byte[] cv) {
		
			this.cv = cv;
		
		
	}


	

@Transient
	public boolean isDateNotValid() {
		return isDateNotValid;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
