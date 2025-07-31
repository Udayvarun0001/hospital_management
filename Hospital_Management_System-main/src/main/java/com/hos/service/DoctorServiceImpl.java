package com.hos.service;


import com.hos.model.Doctor;
import com.hos.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;


	@Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    @Override
    public Doctor getDoctorById(int id) {
        return doctorRepo.findById(id).orElse(null);
    }
    
    @Override
    public void deleteDoctorById(int id) {
    	doctorRepo.deleteById(id);
    }

	@Override
	public List<Doctor> findBySpecialization(String disease) {
		return doctorRepo.findBySpecialization(disease);
	}
}
