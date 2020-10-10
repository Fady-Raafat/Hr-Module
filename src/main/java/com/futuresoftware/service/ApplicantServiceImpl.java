package com.futuresoftware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futuresoftware.entities.Applicant;
import com.futuresoftware.repository.ApplicantRepository;

@Service
public class ApplicantServiceImpl implements ApplicantService {
	
	@Autowired
	ApplicantRepository applicantRepo;

	@Override
	public Applicant saveApplicant(Applicant applicant)  {
	
		return applicantRepo.save(applicant);
	}

	@Override
	public Applicant updateApplicant(Applicant applicant) {
		
		return applicantRepo.save(applicant);
	}

	@Override
	public void deleteApplicant(int id) {
		
		applicantRepo.deleteById(id);
	}

	@Override
	public List<Applicant> getAllApplicants() {
		
		return applicantRepo.findAll();
	}

	@Override
	public Applicant getApplicantById(int id) {
		
		return applicantRepo.findById(id).orElse(null);
	}

	@Override
	public Applicant getApplicantByusername(String username) {

		return applicantRepo.getApplicantByUsername(username);
	}



}
