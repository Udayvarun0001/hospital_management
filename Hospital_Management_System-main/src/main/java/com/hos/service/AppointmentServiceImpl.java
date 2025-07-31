package com.hos.service;

import com.hos.model.Appointment;
import com.hos.model.Doctor;
import com.hos.model.Patient;
import com.hos.repo.AppointmentRepo;
import com.hos.repo.DoctorRepo;
import com.hos.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private PatientRepo patientRepo;

    public AppointmentServiceImpl(AppointmentRepo appointmentRepo, DoctorRepo doctorRepo, PatientRepo patientRepo) {
        this.appointmentRepo = appointmentRepo;
        this.doctorRepo = doctorRepo;
        this.patientRepo = patientRepo;
    }

    @Override
    public String bookAppointment(int doctorId, int patientId, String datetime, String purpose) {
        // Parse date and time
        LocalDateTime dateTimeParsed = LocalDateTime.parse(datetime);

        // Check if doctor is already booked at this time
        Appointment existing = appointmentRepo.findByDoctorAndDateTime(doctorId, dateTimeParsed);
        if (existing != null) {
            return "Doctor is not available at the selected time. Please choose a different time.";
        }

        // Fetch doctor and patient
        Doctor doctor = doctorRepo.findById(doctorId).orElse(null);
        Patient patient = patientRepo.findById(patientId).orElse(null);

        if (doctor == null || patient == null) {
            return "Invalid doctor or patient ID.";
        }

        // Create new appointment — DO NOT set ID manually
        Appointment appointment = new Appointment();
        appointment.setAppointmentDateTime(dateTimeParsed);
        appointment.setPurpose(purpose);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        appointmentRepo.save(appointment);
        return "Appointment booked successfully!";
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    @Override
    public List<Doctor> findBySpecialization(String specialization) {
        return doctorRepo.findBySpecialization(specialization);
    }


}
