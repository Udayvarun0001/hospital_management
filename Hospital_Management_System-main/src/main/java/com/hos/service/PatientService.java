package com.hos.service;

import java.util.List;

import com.hos.model.Patient;

public interface PatientService {
	List<Patient> getAllPatients();
	void savePatient(Patient patient);
	Patient getPatientById(int id);
	void deletePatientById(int id);
}
