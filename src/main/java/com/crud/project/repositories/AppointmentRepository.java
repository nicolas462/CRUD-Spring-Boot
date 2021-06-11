package com.crud.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.project.entities.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

	boolean existsByIdPatientAndIdDoctorAndAssignedDate(int idPatient, int idDoctor, String date);
}
