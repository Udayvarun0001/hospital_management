package com.hos.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Doctor {

    @Id
    private Integer id;

    private String name;
    private String specialization;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Doctor(Integer id, String name, String specialization, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.email = email;
		this.phone = phone;
	}

	
	public Doctor() {
		super();
	}

	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", email=" + email
				+ ", phone=" + phone + ", appointments=" + appointments + "]";
	}
    
    
    
    // Constructors, Getters, Setters...
}
