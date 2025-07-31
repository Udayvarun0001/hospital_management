package com.hos.service;

import java.util.List;

import com.hos.model.Doctor;

public interface DoctorService {

	Doctor addDoctor(Doctor doctor);

	List<Doctor> getAllDoctors();

	Doctor getDoctorById(int id);

	void deleteDoctorById(int id);

	List<Doctor> findBySpecialization(String disease);

}
