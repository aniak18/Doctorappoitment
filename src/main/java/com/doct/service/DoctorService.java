package com.doct.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import com.doct.entity.Appointment;
import com.doct.entity.CurrentSession;
import com.doct.entity.Doctor;
import com.doct.entity.Patient;
import com.doct.entity.Review;
import com.doct.exception.AppointmentException;
import com.doct.exception.DoctorException;
import com.doct.exception.LoginException;
import com.doct.exception.PatientException;
import com.doct.exception.ReviewException;
import com.doct.exception.TimeDateException;


public interface DoctorService {
	
	List<Doctor> getAllDoctorsRegisterFromDatabase() throws DoctorException;
	
	Doctor getDoctorByUuid(String uuid) throws PatientException;
	
	CurrentSession getCurrentUserByUuid(String uuid) throws LoginException;
	
	List<LocalDateTime> getDoctorAvailableTimingForBooking(String key, Doctor doctor) throws IOException, TimeDateException, DoctorException;
	
	List<Appointment> getUpcommingDoctorAppointment(Doctor doctor) throws AppointmentException;
	
	List<Appointment> getPastDoctorAppointment(Doctor doctor) throws AppointmentException;
	
	List<Appointment> getAllAppointments(Doctor registerDoctor) throws DoctorException;
	
	Doctor getDoctorDetails(String key) throws PatientException;

	Review getReviewOfParticularAppointment(String key, Appointment appointment) throws PatientException, ReviewException;

	List<Patient> getListOfPatient();
	
}
