package com.crud.project.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.crud.project.entities.Patient;

@Service
public interface PatientService {
	
	/**
	 * Get all records in the database of the patient table.
	 * @return = All rows registered.
	 */
	public List<Patient> getPatients();
	
	/**
	 * Add a new patient row to the patient table of the database.
	 * @param patient = JSON with all the parameters of patient entity.
	 * @return = String message with the transaction result.
	 */
	public void addPatient(Patient patient);
	
	/**
	 * Update an patient entity present in the database.
	 * @param patient = Appointment entity containing all the information about a patient,
	 * a patient and the date. 
	 */
	public void updatePatient(Patient patient);
	
	/**
	 * Delete a record from patient table in the database.
	 * @param id = identifier column of the register.
	 */
	public void deletePatient(int id);
}
