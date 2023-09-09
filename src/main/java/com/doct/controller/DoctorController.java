package com.doct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.doct.service.DoctorLoginService;
import com.doct.service.DoctorService;


@RestController
public class DoctorController {
	
	@Autowired
	DoctorLoginService doctorLoginService;
	
	@Autowired
	DoctorService doctorService;
	
	@GetMapping("/getDoctorDetails")
	@CrossOrigin
	public ResponseEntity<Doctor> getDoctorDetails(@RequestParam String key) throws LoginException, PatientException{
		
		if(doctorLoginService.checkUserLoginOrNot(key)) {
			
			Doctor returnDoctor = doctorService.getDoctorDetails(key); 
			
			return new ResponseEntity<Doctor>(returnDoctor, HttpStatus.ACCEPTED);
		
		}else {
			
			throw new LoginException("Please enter valid key");
			
		}
	}
	
	
	
	@GetMapping("/upcomingAppointments")
	@CrossOrigin
	public ResponseEntity<List<Appointment>> getUpcomingAppointments(@RequestParam String key) throws LoginException, PatientException, DoctorException, AppointmentException{ 
		
		if(doctorLoginService.checkUserLoginOrNot(key)) {
			
			CurrentSession currentUserSession = doctorService.getCurrentUserByUuid(key);
			
			Doctor registerDoctor = doctorService.getDoctorByUuid(key);
			
			if(!currentUserSession.getUserType().equals("doctor")) { 
				
				throw new LoginException("Please login as doctor");
				
			}
			
			if(registerDoctor != null) {
				
				List<Appointment> listOfUpCommingAppointment = doctorService.getUpcommingDoctorAppointment(registerDoctor);
				
				return new ResponseEntity<List<Appointment>>(listOfUpCommingAppointment, HttpStatus.ACCEPTED);
				
				
			}else {
				
				throw new DoctorException("Please enter valid doctor details");
				
			}
		
		}else {
			
			throw new LoginException("Please enter valid key");
			
		}
		
	}
	
	@GetMapping("/pastAppointments")
	@CrossOrigin
	public ResponseEntity<List<Appointment>> getPastAppointments(@RequestParam String key) throws LoginException, PatientException, AppointmentException, DoctorException{
		
		if(doctorLoginService.checkUserLoginOrNot(key)) {
			
			CurrentSession currentUserSession = doctorService.getCurrentUserByUuid(key);
			
			Doctor registerDoctor = doctorService.getDoctorByUuid(key);
			
			if(!currentUserSession.getUserType().equals("doctor")) { 
				
				throw new LoginException("Please login as doctor");
				
			}
			
			if(registerDoctor != null) {
				
				List<Appointment> listOfUpPastAppointment = doctorService.getPastDoctorAppointment(registerDoctor);
				
				return new ResponseEntity<List<Appointment>>(listOfUpPastAppointment, HttpStatus.ACCEPTED);
				
				
			}else {
				
				throw new DoctorException("Please enter valid doctor details");
				
			}
		
		}else {
			
			throw new LoginException("Please enter valid key");
			
		}
		
	}
	
	@GetMapping("/getAllAppointments")
	@CrossOrigin
	public ResponseEntity<List<Appointment>> getAllAppointments(@RequestParam String key) throws LoginException, PatientException, AppointmentException, DoctorException{
		
		if(doctorLoginService.checkUserLoginOrNot(key)) { 
			
			CurrentSession currentUserSession = doctorService.getCurrentUserByUuid(key);
			
			Doctor registerDoctor = doctorService.getDoctorByUuid(key);
			
			if(!currentUserSession.getUserType().equals("doctor")) { 
				
				throw new LoginException("Please login as doctor");
				
			}
			
			if(registerDoctor != null) {
				
				List<Appointment> listOfUpPastAppointment = doctorService.getAllAppointments(registerDoctor);
				
				return new ResponseEntity<List<Appointment>>(listOfUpPastAppointment, HttpStatus.ACCEPTED);
				
				
			}else {
				
				throw new DoctorException("Please enter valid doctor details");
				
			}
		
		}else {
			
			throw new LoginException("Please enter valid key");
			
		}
		
	}
	
	@PostMapping("/getReivew")
	@CrossOrigin
	public ResponseEntity<Review> getReviewOfParticularAppointment(@RequestParam String key, @RequestBody Appointment appointment) throws LoginException, DoctorException, PatientException, ReviewException {
		
		if(doctorLoginService.checkUserLoginOrNot(key)) { 
			
			CurrentSession currentUserSession = doctorService.getCurrentUserByUuid(key);
			
			Doctor registerDoctor = doctorService.getDoctorByUuid(key);
			
			if(!currentUserSession.getUserType().equals("doctor")) { 
				
				throw new LoginException("Please login as doctor");
				
			}
			
			if(registerDoctor != null) {
				
				Review review = doctorService.getReviewOfParticularAppointment(key, appointment);
				
				return new ResponseEntity<Review>(review, HttpStatus.OK);
				
			}else {
				
				throw new DoctorException("Please enter valid doctor details");
				
			}
		
		}else {
			
			throw new LoginException("Please enter valid key");
			
		}
		
	}
	
	
	@GetMapping("/listOfPatient")
	@CrossOrigin
	public ResponseEntity<List<Patient>> getAllListOfPatient(@RequestParam String key) throws DoctorException, LoginException, PatientException{
		
		if(doctorLoginService.checkUserLoginOrNot(key)) { 
			
			CurrentSession currentUserSession = doctorService.getCurrentUserByUuid(key);
			
			Doctor registerDoctor = doctorService.getDoctorByUuid(key);
			
			if(!currentUserSession.getUserType().equals("doctor")) { 
				
				throw new LoginException("Please login as doctor"); 
				
			}
			
			if(registerDoctor != null) {
				
				List<Patient> listOfPatient = doctorService.getListOfPatient();
				
				return new ResponseEntity<List<Patient>>(listOfPatient, HttpStatus.OK);
				
			}else {
				
				throw new DoctorException("Please enter valid doctor details");
				
			}
		
		}else {
			
			throw new LoginException("Please enter valid key"); 
			
		}
	}
	

}


























