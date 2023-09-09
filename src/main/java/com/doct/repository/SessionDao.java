package com.doct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doct.entity.CurrentSession;


public interface SessionDao extends JpaRepository<CurrentSession, Integer> {
	
	public CurrentSession findByUuid(String uuid);
	
}
