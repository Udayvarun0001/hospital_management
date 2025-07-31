package com.hos.controller;

import com.hos.model.Doctor;
import com.hos.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // 1. Show all doctors
    @GetMapping("/doctors")
    public String viewDoctors(Model model) {
        List<Doctor> list = doctorService.getAllDoctors();
        model.addAttribute("listDoctors", list);
        return "new_doctor"; // Use the correct JSP for doctor list
    }

    // 2. Show new doctor form
    @GetMapping("/showNewDoctorForm")
    public String showNewDoctorForm(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "doctor-form"; // You'll need to create doctor-form.jsp
    }

    // 3. Save doctor (create or update)
    @PostMapping("/saveDoctor")
    public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.addDoctor(doctor);
        return "redirect:/doctors";
    }

    // 4. Show form to update doctor
    @GetMapping("/showFormForUpdateDoctor/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "doctor-form"; // Reuses same form
    }

    // 5. Delete doctor
    @GetMapping("/deleteDoctor/{id}")
    public String deleteDoctor(@PathVariable(value = "id") int id) {
        doctorService.deleteDoctorById(id);
        return "redirect:/doctors";
    }    
// All booking-related mappings have been removed. Only doctor CRUD endpoints remain.

}
