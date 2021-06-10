package com.crud.project.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.project.entities.Appointment;
import com.crud.project.repositories.AppointmentRepository;
import com.crud.project.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService
{
	@Autowired
	AppointmentRepository appointmentRepository;
	
	public List <Appointment> getAppointments() {
		List <Appointment> listAppointments = new ArrayList<Appointment>();
		appointmentRepository.findAll().forEach(listAppointments :: add);
		return listAppointments;
	}
	
	public void addAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
	}
	
	public void updateAppointment(Appointment appointment)	{
		appointmentRepository.save(appointment);
	}
	
	public void deleteAppointment(int id) {
		appointmentRepository.deleteById(id);
	}
}
