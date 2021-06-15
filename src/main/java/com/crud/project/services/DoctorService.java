package com.crud.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.project.entities.Doctor;

@Service
public interface DoctorService {
	
	/**
	 * Get all records in the database of the doctor table.
	 * @return = All rows registered.
	 */
	public List<Doctor> getDoctors();
	
	/**
	 * Add a new doctor row to the doctor table of the database.
	 * @param doctor = Doctor object with all the parameters of doctor entity.
	 * @return = String message with the transaction result.
	 */
	public void addDoctor(Doctor doctor);
	
	/**
	 * Update an doctor entity present in the database.
	 * @param doctor = Appointment entity containing all the information about a patient,
	 * a doctor and the date. 
	 */
	public void updateDoctor(Doctor doctor);
	
	/**
	 * Delete a record from doctor table in the database.
	 * @param id = identifier column of the register.
	 */
	public void deleteDoctor(int id);
	
	/**
	 * Find a Doctor by the id given in the Doctor column.
	 * @param id = identifier column of the register.
	 * @return = the record found or an empty record if it's not found.
	 */
	public Optional<Doctor> findDoctorById(int id);
}
