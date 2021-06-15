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

import com.crud.project.entities.Patient;
import com.crud.project.services.impl.PatientServiceImpl;

@RestController
public class PatientController {
	
	@Autowired
	PatientServiceImpl patientServiceImpl;
	
	/**
	 * List all records in the database of the patient table.
	 * @return = JSON of all data.
	 */
	@GetMapping("/patient/list")
	public List<Patient> getPatients() {
		return patientServiceImpl.getPatients();
	}
	
	/**
	 * Add a new patient row to the patient table of the database.
	 * @param patient = JSON with all the parameters of patient entity.
	 */
	@PostMapping("/patient/add")
	public void addPatient(@RequestBody Patient patient) {
		patientServiceImpl.addPatient(patient);
	}
	
	/**
	 * Update an patient entity present in the database.
	 * @param patient = JSON with all the parameters of patient entity. 
	 */
	@PutMapping("/patient/update")
	public void updatePatient(@RequestBody Patient patient) {
		patientServiceImpl.updatePatient(patient);
	}
	
	/**
	 * Delete a record from patient table in the database.
	 * @param id = identifier column of the register.
	 */
	@DeleteMapping("/patient/delete/{id}")
	public void deletePatient(@PathVariable int id) {
		patientServiceImpl.deletePatient(id);
	}
}
