package com.futuresoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futuresoftware.entities.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

	public Applicant getApplicantByUsername(String username);
}
