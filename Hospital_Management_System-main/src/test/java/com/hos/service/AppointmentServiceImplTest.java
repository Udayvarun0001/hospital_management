package com.hos.service;

import com.hos.model.Appointment;
import com.hos.model.Doctor;
import com.hos.model.Patient;
import com.hos.repo.AppointmentRepo;
import com.hos.repo.DoctorRepo;
import com.hos.repo.PatientRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AppointmentServiceImplTest {

    private AppointmentRepo appointmentRepo;
    private DoctorRepo doctorRepo;
    private PatientRepo patientRepo;
    private AppointmentServiceImpl appointmentService;

    @BeforeEach
    void setUp() {
        appointmentRepo = Mockito.mock(AppointmentRepo.class);
        doctorRepo = Mockito.mock(DoctorRepo.class);
        patientRepo = Mockito.mock(PatientRepo.class);
        appointmentService = new AppointmentServiceImpl(appointmentRepo, doctorRepo, patientRepo);
    }

    @Test
    void testGetAllAppointments() {
        Appointment a1 = new Appointment(1, LocalDateTime.now(), "Checkup", new Doctor(), new Patient());
        Appointment a2 = new Appointment(2, LocalDateTime.now().plusDays(1), "Consultation", new Doctor(), new Patient());

        when(appointmentRepo.findAll()).thenReturn(Arrays.asList(a1, a2));

        List<Appointment> result = appointmentService.getAllAppointments();

        assertThat(result).hasSize(2);
        verify(appointmentRepo, times(1)).findAll();
    }

    @Test
    void testBookAppointmentSuccessfully() {
        Doctor doctor = new Doctor(101, "Dr. Kumar", "Ortho", "kumar@hos.com", "99999");
        Patient patient = new Patient(102, "Ramesh", "Ortho", "88888", "Bangalore");

        when(doctorRepo.findById(1)).thenReturn(Optional.of(doctor));
        when(patientRepo.findById(1)).thenReturn(Optional.of(patient));
        when(appointmentRepo.findByDoctorAndDateTime(eq(1), any())).thenReturn(null);

        String result = appointmentService.bookAppointment(1, 1, "2025-07-20T10:00", "Back Pain");

        assertThat(result).isEqualTo("Appointment booked successfully!");
        verify(appointmentRepo, times(1)).save(any(Appointment.class));
    }

    @Test
    void testBookAppointmentDoctorUnavailable() {
        when(appointmentRepo.findByDoctorAndDateTime(eq(1), any()))
                .thenReturn(new Appointment());

        String result = appointmentService.bookAppointment(1, 1, "2025-07-20T10:00", "Back Pain");

        assertThat(result).isEqualTo("Doctor is not available at the selected time. Please choose a different time.");
    }

    @Test
    void testBookAppointmentInvalidDoctorOrPatient() {
        when(doctorRepo.findById(99)).thenReturn(Optional.empty());
        when(patientRepo.findById(99)).thenReturn(Optional.empty());

        String result = appointmentService.bookAppointment(99, 99, "2025-07-20T10:00", "Fever");

        assertThat(result).isEqualTo("Invalid doctor or patient ID.");
    }
}
