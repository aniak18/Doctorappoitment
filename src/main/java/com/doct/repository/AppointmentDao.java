package com.doct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doct.entity.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment, Integer> {

}
