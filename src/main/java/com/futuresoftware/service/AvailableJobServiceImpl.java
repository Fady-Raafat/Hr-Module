package com.futuresoftware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futuresoftware.entities.AvailableJob;
import com.futuresoftware.repository.AvailableJobRepository;

@Service
public class AvailableJobServiceImpl implements AvailableJobService {

	@Autowired
	AvailableJobRepository jobRepo;

	@Override
	public AvailableJob saveAvailableJob(AvailableJob availableJob) {

		return jobRepo.save(availableJob);
	}

	@Override
	public AvailableJob updateAvailableJob(AvailableJob availableJob) {
		
		return jobRepo.save(availableJob);
	}

	@Override
	public void deleteAvailableJob(int id) {
		
		jobRepo.deleteById(id);
	}

	@Override
	public List<AvailableJob> getAllAvailableJobs() {
		
		return jobRepo.findAll();
	}

	@Override
	public AvailableJob getAvailableJobById(int id) {
		
		return jobRepo.findById(id).orElse(null);
	}

}
