package com.doct.service;

import java.util.List;

import com.doct.entity.Doctor;
import com.doct.entity.Message;
import com.doct.entity.Patient;
import com.doct.exception.DoctorException;
import com.doct.exception.PatientException;

public interface MessageService {
	
	Message sendMessageFromPatientToDoctor(String key, Message message) throws PatientException, DoctorException;

	Message sendMessageFromDoctorToPatient(String key, Message message) throws PatientException, DoctorException;

	List<Message> getMessageOfPatientParticularDoctor(String key, Doctor doctor) throws DoctorException, PatientException;

	List<Message> getMessageOfDoctorParticularPatient(String key, Patient patient) throws DoctorException, PatientException;

}
