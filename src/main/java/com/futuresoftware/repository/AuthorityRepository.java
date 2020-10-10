package com.futuresoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futuresoftware.entities.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}
