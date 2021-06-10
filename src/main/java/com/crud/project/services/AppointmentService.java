package com.crud.project.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.crud.project.entities.Appointment;

@Service
public interface AppointmentService
{
	public List <Appointment> getAppointments();
	
	public String addAppointment(Appointment appointment);
	
	public String updateAppointment(Appointment appointment);
	
	public void deleteAppointment(int id);
}
