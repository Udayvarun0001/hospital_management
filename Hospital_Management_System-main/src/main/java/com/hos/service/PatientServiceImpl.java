package com.hos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hos.model.Patient;
import com.hos.repo.PatientRepo;

@Service
public class PatientServiceImpl implements PatientService{
    private final PatientRepo patientRepository;

	@Autowired
	public PatientServiceImpl(PatientRepo patientRepository) {
        this.patientRepository = patientRepository;
    }

	
	@Override
	public List<Patient> getAllPatients()
	{
		return patientRepository.findAll();
	}
	
	@Override
	public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(int id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePatientById(int id) {
        patientRepository.deleteById(id);
    }
}
