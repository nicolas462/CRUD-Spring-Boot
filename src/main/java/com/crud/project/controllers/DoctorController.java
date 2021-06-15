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
public class DoctorController {
	
	@Autowired
	DoctorServiceImpl doctorServiceImpl;
	
	/**
	 * List all records in the database of the doctor table.
	 * @return = JSON of all data.
	 */
	@GetMapping("/doctor/list")
	public List<Doctor> getDoctors() {
		return doctorServiceImpl.getDoctors();
	}
	
	/**
	 * Add a new doctor row to the doctor table of the database.
	 * @param doctor = JSON with all the parameters of doctor entity.
	 */
	@PostMapping("/doctor/add")
	public void addDoctor(@RequestBody Doctor doctor) {
		doctorServiceImpl.addDoctor(doctor);
	}
	
	/**
	 * Update an doctor entity present in the database.
	 * @param doctor = JSON with all the parameters of doctor entity. 
	 */
	@PutMapping("/doctor/update")
	public void updateDoctor(@RequestBody Doctor doctor) {
		doctorServiceImpl.updateDoctor(doctor);
	}
	
	/**
	 * Delete a record from doctor table in the database.
	 * @param id = identifier column of the register.
	 */
	@DeleteMapping("/doctor/delete/{id}")
	public void deleteDoctor(@PathVariable int id) {
		doctorServiceImpl.deleteDoctor(id);
	}
}
