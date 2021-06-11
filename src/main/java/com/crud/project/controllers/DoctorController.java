package com.crud.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.project.entities.Doctor;
import com.crud.project.services.impl.DoctorServiceImpl;

@RestController
public class DoctorController
{
	@Autowired
	DoctorServiceImpl doctorServiceImpl;
	
	@GetMapping("/doctor/list")
	public List <Doctor> getDoctors() {
		return doctorServiceImpl.getDoctors();
	}
	
	@PostMapping("/doctor/add")
	public void addDoctor(@RequestBody Doctor doctor) {
		doctorServiceImpl.addDoctor(doctor);
	}
	
	@PutMapping("/doctor/update")
	public void updateDoctor(@RequestBody Doctor doctor) {
		doctorServiceImpl.updateDoctor(doctor);
	}
	
	@DeleteMapping("/doctor/delete/{id}")
	public void deleteDoctor(@PathVariable int id) {
		doctorServiceImpl.deleteDoctor(id);
	}
}
