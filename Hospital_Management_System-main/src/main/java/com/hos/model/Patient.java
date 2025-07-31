package com.hos.model;

import java.util.List;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Patient {
	@Id
	private Integer id;
	
	private String name;
	private String disease;
	private String phone;
	private String address;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<Appointment> appointments;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Patient() {
	    // default constructor required by Hibernate
	}

	public Patient(Integer id, String name, String disease, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.disease = disease;
		this.phone = phone;
		this.address = address;
	}
	
	
	
}