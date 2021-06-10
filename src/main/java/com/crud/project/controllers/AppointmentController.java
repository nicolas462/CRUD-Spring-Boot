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

import com.crud.project.entities.Appointment;
import com.crud.project.services.impl.AppointmentServiceImpl;

@RestController
public class AppointmentController
{
	@Autowired
	AppointmentServiceImpl appointmentServiceImpl;
	
	@GetMapping("/appointment/list")
	public List <Appointment> getAppointments() {
		return appointmentServiceImpl.getAppointments();
	}
	
	@PostMapping("/appointment/add")
	public void addAppointment(@RequestBody Appointment appointment) {
		appointmentServiceImpl.addAppointment(appointment);
	}
	
	@PutMapping("/appointment/update")
	public void updateAppointment(@RequestBody Appointment appointment) {
		appointmentServiceImpl.updateAppointment(appointment);
	}
	
	@DeleteMapping("/appointment/delete/{id}")
	public void deleteAppointment(@PathVariable int id) {
		appointmentServiceImpl.deleteAppointment(id);
	}
}