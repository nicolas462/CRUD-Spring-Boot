package com.crud.project.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.project.entities.Patient;
import com.crud.project.repositories.PatientRepository;
import com.crud.project.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	/**
	 * Get all records in the database of the patient table.
	 * @return = All rows registered.
	 */
	public List <Patient> getPatients() {
		List <Patient> listPatients = new ArrayList<>();
		patientRepository.findAll().forEach(listPatients :: add);
		return listPatients;
	}
	
	/**
	 * Add a new patient row to the patient table of the database.
	 * @param patient = Patient object with all the parameters of patient entity.
	 * @return = String message with the transaction result.
	 */
	public void addPatient(Patient patient) {
		patientRepository.save(patient);
	}
	
	/**
	 * Update an patient entity present in the database.
	 * @param patient = Appointment entity containing all the information about a patient,
	 * a patient and the date. 
	 */
	public void updatePatient(Patient patient)	{
		patientRepository.save(patient);
	}
	
	/**
	 * Delete a record from patient table in the database.
	 * @param id = identifier column of the register.
	 */
	public void deletePatient(int id) {
		patientRepository.deleteById(id);
	}
	
	/**
	 * Find a Patient by the id given in the Patient column.
	 * @param id = identifier column of the register.
	 * @return = the record found or an empty record if it's not found.
	 */
	public Optional<Patient> findPatientById(int id) {
		return patientRepository.findById(id);
	}
}
