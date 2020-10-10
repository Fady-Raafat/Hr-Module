package com.futuresoftware.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futuresoftware.entities.Applicant;
import com.futuresoftware.service.ApplicantService;

@RestController
@RequestMapping(value= "/applicants")
public class ApplicantController {
	
	@Autowired
	ApplicantService applicantService;
	
	@GetMapping("/")
	public List<Applicant> getAllApplicants(){
		
		return applicantService.getAllApplicants();
	}
	
	@GetMapping("/{id}")
	public Applicant getApplicantById(@PathVariable("id") int id) {
		
		return applicantService.getApplicantById(id);
	}
	
	@PostMapping
	public Applicant createApplicant(@RequestBody Applicant applicant) {
		
		return applicantService.saveApplicant(applicant);
	}
	
	@PutMapping
	public Applicant updateApplicant(@RequestBody Applicant applicant) {
		return applicantService.updateApplicant(applicant);
	}
	
	@DeleteMapping("/{id}")
	public void deleteApplicant(@PathVariable int id) {
		
		applicantService.deleteApplicant(id);
	}
	

}
