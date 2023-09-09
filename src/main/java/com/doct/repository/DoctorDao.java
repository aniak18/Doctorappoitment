package com.doct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doct.entity.Doctor;

public interface DoctorDao extends JpaRepository<Doctor, Integer> {
	
	public Doctor findByMobileNo(String mobileNo);
}
