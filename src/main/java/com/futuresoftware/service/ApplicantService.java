package com.futuresoftware.service;

import java.util.List;

import com.futuresoftware.entities.Applicant;

public interface ApplicantService {

	public Applicant saveApplicant(Applicant applicant);

	public Applicant updateApplicant(Applicant applicant);

	public void deleteApplicant(int id);

	public List<Applicant> getAllApplicants();

	public Applicant getApplicantById(int id);
	
	public Applicant getApplicantByusername(String username);

}
