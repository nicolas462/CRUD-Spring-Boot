package com.crud.project.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.crud.project.entities.Appointment;

@Service
public interface AppointmentService {
	
	/**
	 * Get all records in the database of the appointment table.
	 * @return = All rows registered.
	 */
	public List<Appointment> getAppointments();
	
	/**
	 * Add a new appointment row to the appointment table of the database.
	 * @param appointment = JSON with all the parameters of appointment entity.
	 * @return = String message with the transaction result.
	 */
	public String addAppointment(Appointment appointment);
	
	/**
	 * Update an appointment entity present in the database.
	 * @param appointment = Appointment entity containing all the information about a patient,
	 * a doctor and the date. 
	 */
	public void updateAppointment(Appointment appointment);
	
	/**
	 * Delete a record from appointment table in the database.
	 * @param id = identifier column of the register.
	 */
	public void deleteAppointment(int id);
}
