package com.crud.project.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.crud.project.dto.DoctorDTO;
import com.crud.project.entities.Doctor;

@Component
public class DoctorConverter {

	public Doctor dtoToEntity(DoctorDTO doctorDto) {
		var doctor = new Doctor();
		doctor.setId(doctorDto.getId());
		doctor.setName(doctorDto.getName());
		doctor.setIdentification(doctorDto.getIdentification());
		doctor.setIdType(doctorDto.getIdType());
		doctor.setProfesionalCardNumber(doctorDto.getProfesionalCardNumber());
		doctor.setYearsExp(doctorDto.getYearsExp());
		doctor.setSpeciality(doctorDto.getSpeciality());
		doctor.setInitSch(doctorDto.getInitSch());
		doctor.setEndSch(doctorDto.getEndSch());
		return doctor;
	}
	
	public DoctorDTO entityToDto(Doctor doctor) {
		return new DoctorDTO(doctor);
	}
	
	public List<DoctorDTO> entityToDto(List<Doctor> doctor) {
		return doctor.stream().map(DoctorDTO::new).collect(Collectors.toList());
	}
}