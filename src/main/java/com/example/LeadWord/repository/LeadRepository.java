package com.example.LeadWord.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LeadWord.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

	//boolean existsByLeadId(Integer leadId);

	boolean existsByEmail(String email);

	boolean existsByLeadId(Long leadId);
}