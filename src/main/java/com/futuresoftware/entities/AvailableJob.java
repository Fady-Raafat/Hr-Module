package com.futuresoftware.entities;

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

@Entity
@Table(name="availablejob")

public class AvailableJob {
	
	
	
	public AvailableJob(String jobName, String description, int reqExperienceYears) {
		super();
		this.jobName = jobName;
		this.description = description;
		this.reqExperienceYears = reqExperienceYears;
	}

	public AvailableJob() {

	
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "availablejobid")
	private int availJobId;
	
	@Column(name = "Jobname")
	private String jobName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "requiredexperienceyears")
	private int reqExperienceYears;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "availableJob")
	 List<Applicant> applicantsList;


	public int getAvailJobId() {
		return availJobId;
	}


	public void setAvailJobId(int availJobId) {
		this.availJobId = availJobId;
	}


	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getReqExperienceYears() {
		return reqExperienceYears;
	}


	public void setReqExperienceYears(int reqExperienceYears) {
		this.reqExperienceYears = reqExperienceYears;
	}


//	public List<Applicant> getApplicantsList() {
//		return applicantsList;
//	}
//
//
//	public void setApplicantsList(List<Applicant> applicantsList) {
//		this.applicantsList = applicantsList;
//	}
	
	
	
}
