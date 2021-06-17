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

import com.crud.project.converters.AppointmentConverter;
import com.crud.project.dto.AppointmentDTO;
import com.crud.project.entities.Appointment;
import com.crud.project.services.impl.AppointmentServiceImpl;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentServiceImpl appointmentServiceImpl;
	@Autowired
	AppointmentConverter appointmentConverter;
	
	/**
	 * List all records in the database of the appointment table.
	 * @return = JSON of all data.
	 */
	@GetMapping("/appointment/list")
	public List<AppointmentDTO> getAppointments() {
		List<Appointment> findAll = appointmentServiceImpl.getAppointments(); 
		return appointmentConverter.entityToDto(findAll);
	}
	
	/**
	 * Add a new appointment row to the appointment table of the database.
	 * @param appointment = JSON with all the parameters of appointment entity.
	 * @return = String message with the transaction result.
	 */
	@PostMapping("/appointment/add")
	public String addAppointment(@RequestBody AppointmentDTO appointmentDto) {
		var appointment = appointmentConverter.dtoToEntity(appointmentDto);
		return appointmentServiceImpl.addAppointment(appointment);
	}
	
	/**
	 * Update an appointment entity present in the database.
	 * @param appointment = JSON with all the parameters of appointment entity. 
	 */
	@PutMapping("/appointment/update")
	public void updateAppointment(@RequestBody AppointmentDTO appointmentDto) {
		var appointment = appointmentConverter.dtoToEntity(appointmentDto);
		appointmentServiceImpl.updateAppointment(appointment);
	}
	
	/**
	 * Delete a record from appointment table in the database.
	 * @param id = identifier column of the register.
	 */
	@DeleteMapping("/appointment/delete/{id}")
	public void deleteAppointment(@PathVariable int id) {
		appointmentServiceImpl.deleteAppointment(id);
	}
}