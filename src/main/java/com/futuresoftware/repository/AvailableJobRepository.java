package com.futuresoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futuresoftware.entities.AvailableJob;

public interface AvailableJobRepository extends JpaRepository<AvailableJob, Integer> {

}
