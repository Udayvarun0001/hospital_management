package com.hos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hos.model.Patient;

public interface PatientRepo extends JpaRepository<Patient,Integer>{

}
