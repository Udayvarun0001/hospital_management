package com.hos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.hos.model.Doctor;
import com.hos.service.AppointmentService;
import com.hos.service.DoctorService;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/bookAppointmentForm")
    public String showDiseaseForm() {
        return "selectDisease";
    }

    @GetMapping("/availableDoctors")
    public String showAvailableDoctors(@RequestParam String disease, Model model) {
        List<Doctor> doctors = doctorService.findBySpecialization(disease);
        model.addAttribute("doctors", doctors);
        model.addAttribute("disease", disease);
        return "availableDoctors";
    }

    @PostMapping("/bookAppointment")
    public String bookAppointment(@RequestParam int doctorId,
                                  @RequestParam int patientId,
                                  @RequestParam String datetime,
                                  @RequestParam String purpose,
                                  @RequestParam String disease,
                                  Model model) {
        String message = appointmentService.bookAppointment(doctorId, patientId, datetime, purpose);
        // Reload doctors for the same disease after booking
        List<Doctor> doctors = doctorService.findBySpecialization(disease);
        model.addAttribute("doctors", doctors);
        model.addAttribute("disease", disease);
        model.addAttribute("msg", message);
        return "availableDoctors";
    }
    
    @GetMapping("/availableSlots")
    @ResponseBody
    public java.util.List<String> getAvailableSlots(@RequestParam int doctorId, @RequestParam String date) {
        // Parse the date
        LocalDate localDate = LocalDate.parse(date);
        // Define slot times
        LocalTime[] slotStarts = {
            LocalTime.of(11, 0), LocalTime.of(11, 30),
            LocalTime.of(12, 0), LocalTime.of(12, 30),
            LocalTime.of(14, 0), LocalTime.of(14, 30),
            LocalTime.of(15, 0), LocalTime.of(15, 30)
        };
        LocalTime[] slotEnds = {
            LocalTime.of(11, 30), LocalTime.of(12, 0),
            LocalTime.of(12, 30), LocalTime.of(13, 0),
            LocalTime.of(14, 30), LocalTime.of(15, 0),
            LocalTime.of(15, 30), LocalTime.of(16, 0)
        };
        // Get all appointments for this doctor on this date
        java.util.List<com.hos.model.Appointment> appointments = appointmentService.getAllAppointments();
        Set<LocalTime> bookedTimes = new HashSet<>();
        for (com.hos.model.Appointment appt : appointments) {
            if (appt.getDoctor().getId() == doctorId &&
                appt.getAppointmentDateTime().toLocalDate().equals(localDate)) {
                bookedTimes.add(appt.getAppointmentDateTime().toLocalTime());
            }
        }
        // Build list of free slots
        java.util.List<String> freeSlots = new ArrayList<>();
        DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("HH:mm");
        for (int i = 0; i < slotStarts.length; i++) {
            if (!bookedTimes.contains(slotStarts[i])) {
                freeSlots.add(slotStarts[i].format(timeFmt) + " - " + slotEnds[i].format(timeFmt));
            }
        }
        return freeSlots;
    }
}
