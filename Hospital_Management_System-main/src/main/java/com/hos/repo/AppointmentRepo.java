package com.hos.repo;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hos.model.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer>{
	// com.hos.repo.AppointmentRepo.java
	@Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.appointmentDateTime = :appointmentDateTime")
	Appointment findByDoctorAndDateTime(@Param("doctorId") int doctorId, @Param("appointmentDateTime") LocalDateTime appointmentDateTime);

}
