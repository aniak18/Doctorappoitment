package com.doct.service;


import java.util.List;

import com.doct.entity.Doctor;
import com.doct.exception.DoctorException;

public interface AdminDoctorService {
	
	
	Doctor registerDoctor(Doctor doctor) throws DoctorException;

	Doctor revokePermissionOfDoctor(Doctor doctor) throws DoctorException; 
	
	Doctor grantPermissionOfDoctor(Doctor doctor) throws DoctorException;
 
	List<Doctor> getAllValidInValidDoctors(String key) throws DoctorException;

}
