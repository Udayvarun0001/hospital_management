package com.hos.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.hos.model.Doctor;
import com.hos.repo.DoctorRepo;

public class DoctorServiceImplTest {

    private DoctorRepo doctorRepo;
    private DoctorServiceImpl doctorService;

    @BeforeEach
    void setUp() {
        doctorRepo = Mockito.mock(DoctorRepo.class);
        doctorService = new DoctorServiceImpl();
    }

    @Test
    void testGetAllDoctors() {
        Doctor d1 = new Doctor(105, "Dr. Rao", "Cardiology", "rao@hos.com", "1234567890");
        Doctor d2 = new Doctor(106, "Dr. Meena", "Dermatology", "meena@hos.com", "0987654321");

        when(doctorRepo.findAll()).thenReturn(Arrays.asList(d1, d2));

        List<Doctor> result = doctorService.getAllDoctors();

        assertThat(result).hasSize(2);
        verify(doctorRepo, times(1)).findAll();
    }

    @Test
    void testAddDoctor() {
        Doctor doctor = new Doctor(104, "Dr. Ajay", "ENT", "ajay@hos.com", "1111111111");

        doctorService.addDoctor(doctor);

        verify(doctorRepo, times(1)).save(doctor);
    }

    @Test
    void testGetDoctorById() {
        Doctor doctor = new Doctor(103, "Dr. Lakshmi", "Neurology", "lakshmi@hos.com", "9999999999");

        when(doctorRepo.findById(1)).thenReturn(Optional.of(doctor));

        Doctor result = doctorService.getDoctorById(1);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Dr. Lakshmi");
    }
}
