package com.crud.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.project.entities.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
	
	/**
	 * Check if it exists a record with the given parameters.
	 * @param idPatient = idPatient from Patient table.
	 * @param idDoctor = idDoctor from Doctor table.
	 * @param date = date to evaluate in format YYYY-MM-DD.
	 * @return
	 */
	boolean existsByIdPatientAndIdDoctorAndAssignedDate(int idPatient, int idDoctor, String date);
}
