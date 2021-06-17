package com.crud.project.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.crud.project.dto.AppointmentDTO;
import com.crud.project.entities.Appointment;

@Component
public class AppointmentConverter {

	public Appointment dtoToEntity(AppointmentDTO appointmentDto) {
		var appointment = new Appointment();
		appointment.setId(appointmentDto.getId());
		appointment.setIdPatient(appointmentDto.getIdPatient());
		appointment.setIdDoctor(appointmentDto.getIdDoctor());
		appointment.setCreationDate(appointmentDto.getCreationDate());
		appointment.setAssignedDate(appointmentDto.getAssignedDate());
		appointment.setAssignedSchedule(appointmentDto.getAssignedSchedule());
		return appointment;
	}
	
	public AppointmentDTO entityToDto(Appointment appointment) {
		return new AppointmentDTO(appointment);
	}
	
	public List<AppointmentDTO> entityToDto(List<Appointment> appointment) {
		return appointment.stream().map(AppointmentDTO::new).collect(Collectors.toList());
	}
}