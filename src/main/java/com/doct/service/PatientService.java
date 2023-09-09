package com.doct.service;

import java.io.IOException;
import java.util.List;
import com.doct.entity.Appointment;
import com.doct.entity.CurrentSession;
import com.doct.entity.Doctor;
import com.doct.entity.ForgetPassword;
import com.doct.entity.Patient;
import com.doct.entity.Review;
import com.doct.exception.AppointmentException;
import com.doct.exception.DoctorException;
import com.doct.exception.LoginException;
import com.doct.exception.PasswordException;
import com.doct.exception.PatientException;
import com.doct.exception.ReviewException;
import com.doct.exception.TimeDateException;

import jakarta.mail.MessagingException;


public interface PatientService {
	
	Patient createPatient(Patient customer) throws PatientException; 
	
	Patient updatePatient(Patient patient, String key) throws PatientException;
	
	Patient getPatientByUuid(String uuid) throws PatientException;
	
	CurrentSession getCurrentUserByUuid(String uuid) throws LoginException;
	
	Appointment bookAppointment(String key, Appointment appointment) throws AppointmentException, LoginException, DoctorException, IOException, TimeDateException, MessagingException;
	
	List<Appointment> getAllAppointmenPatientWise(String key)throws AppointmentException, PatientException;
	
	Appointment updateAppointment(String key, Appointment newAppointment) throws AppointmentException, PatientException, DoctorException, IOException, TimeDateException;
	
	List<Doctor> getAllDoctors() throws DoctorException;
	
	Appointment deleteAppointment(Appointment appointment) throws AppointmentException, DoctorException, Exception;

	Review makeReviewToDoctorAppointment(String key, Review review) throws AppointmentException, DoctorException, ReviewException;
	
	Review updateReview(String key, Review review) throws ReviewException;

	Float getDoctorRating(String key, Doctor doctor) throws DoctorException, ReviewException;

	Patient getPatientDetails(String key) throws PatientException;
	
	Review getReviewOfDoctorByPatient(String key,Review review) throws ReviewException, PatientException, DoctorException, AppointmentException;

	Patient forgetPassword(String key, ForgetPassword forgetPassword) throws PasswordException;

	Review deleteReview(String key, Review review) throws ReviewException; 
	
}
