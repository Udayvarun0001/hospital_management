package com.hos.service;

import com.hos.model.Patient;
import com.hos.repo.PatientRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PatientServiceImplTest {

    private PatientRepo patientRepo;
    private PatientServiceImpl patientService;

    @BeforeEach
    void setUp() {
        patientRepo = Mockito.mock(PatientRepo.class);
        patientService = new PatientServiceImpl(patientRepo); // Constructor injection
    }

    @Test
    void testGetAllPatients() {
        Patient p1 = new Patient(1, "Yasaswini", "Cold", "1234567890", "Vizag");
        Patient p2 = new Patient(2, "Ravi", "Fever", "9876543210", "Delhi");

        when(patientRepo.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Patient> result = patientService.getAllPatients();

        assertThat(result).hasSize(2);
        verify(patientRepo, times(1)).findAll();
    }

    @Test
    void testSavePatient() {
        Patient patient = new Patient(3, "Raju", "Cough", "9999999999", "Chennai");

        patientService.savePatient(patient);

        verify(patientRepo, times(1)).save(patient);
    }

    @Test
    void testGetPatientById() {
        Patient patient = new Patient(4, "Sita", "Flu", "8888888888", "Mumbai");

        when(patientRepo.findById(1)).thenReturn(Optional.of(patient));

        Patient result = patientService.getPatientById(1);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Sita");
    }

    @Test
    void testDeletePatientById() {
        patientService.deletePatientById(1);
        verify(patientRepo, times(1)).deleteById(1);
    }
}
