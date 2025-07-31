package com.hos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hos.model.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer>{

    List<Doctor> findBySpecialization(String specialization);

}



