package com.futuresoftware.service;

import java.util.List;


import com.futuresoftware.entities.AvailableJob;

public interface AvailableJobService {

	public AvailableJob saveAvailableJob(AvailableJob availableJob);

	public AvailableJob updateAvailableJob(AvailableJob availableJob);

	public void deleteAvailableJob(int id);

	public List<AvailableJob> getAllAvailableJobs();

	public AvailableJob getAvailableJobById(int id);

}
