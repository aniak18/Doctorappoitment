package com.doct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doct.entity.Patient;



public interface PatientDao extends JpaRepository<Patient, Integer> {
	
	public Patient findByMobileNo(String mobileNo);
}
