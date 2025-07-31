package com.hos.service;

import java.util.List;

import com.hos.model.Appointment;
import com.hos.model.Doctor;

public interface AppointmentService {

	List<Appointment> getAllAppointments();

	String bookAppointment(int doctorId, int patientId, String datetime, String purpose);
	
	List<Doctor> findBySpecialization(String specialization);

}
