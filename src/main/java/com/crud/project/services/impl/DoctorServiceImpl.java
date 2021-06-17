package com.crud.project.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.project.entities.Doctor;
import com.crud.project.repositories.DoctorRepository;
import com.crud.project.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	/**
	 * Get all records in the database of the doctor table.
	 * @return = All rows registered.
	 */
	public List<Doctor> getDoctors() {
		List<Doctor> listDoctors = new ArrayList<>();
		doctorRepository.findAll().forEach(listDoctors :: add);
		return listDoctors;
	}
	
	/**
	 * Add a new doctor row to the doctor table of the database.
	 * @param doctorDto = Doctor object with all the parameters of doctor entity.
	 * @return = String message with the transaction result.
	 */
	public void addDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
	}
	
	/**
	 * Update an doctor entity present in the database.
	 * @param doctor = Appointment entity containing all the information about a patient,
	 * a doctor and the date. 
	 */
	public void updateDoctor(Doctor doctor)	{
		doctorRepository.save(doctor);
	}
	
	/**
	 * Delete a record from doctor table in the database.
	 * @param id = identifier column of the register.
	 */
	public void deleteDoctor(int id) {
		doctorRepository.deleteById(id);
	}

	/**
	 * Find a Doctor by the id given in the Doctor column.
	 * @param id = identifier column of the register.
	 * @return = the record found or an empty record if it's not found.
	 */
	public Optional<Doctor> findDoctorById(int id) {
		return doctorRepository.findById(id);
	}
}
