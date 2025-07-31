package com.hos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hos.model.Patient;
import com.hos.service.PatientService;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }
        model.addAttribute("listPatients", patientService.getAllPatients());
        return "index"; // maps to index.jsp
    }

    @GetMapping("/showNewPatientForm")
    public String showNewPatientForm(Model model) {
        Patient patient = new Patient(null, null, null, null, null);
        model.addAttribute("patient", patient);
        return "new_patient"; // maps to new_patient.jsp
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "update_patient"; // maps to update_patient.jsp
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable(value = "id") int id) {
        patientService.deletePatientById(id);
        return "redirect:/";
    }
}
