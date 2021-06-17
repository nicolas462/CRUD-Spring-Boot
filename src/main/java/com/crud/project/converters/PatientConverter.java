package com.crud.project.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.crud.project.dto.PatientDTO;
import com.crud.project.entities.Patient;

@Component
public class PatientConverter {

	public Patient dtoToEntity(PatientDTO patientDto) {
		var patient = new Patient();
		patient.setId(patientDto.getId());
		patient.setName(patientDto.getName());
		patient.setIdentification(patientDto.getIdentification());
		patient.setIdType(patientDto.getIdType());
		patient.setBirthDate(patientDto.getBirthDate());
		patient.setHealthEntity(patientDto.getHealthEntity());
		patient.setClinicHistory(patientDto.getClinicHistory());
		return patient;
	}
	
	public PatientDTO entityToDto(Patient patient) {
		return new PatientDTO(patient);
	}
	
	public List<PatientDTO> entityToDto(List<Patient> patient) {
		return patient.stream().map(PatientDTO::new).collect(Collectors.toList());
	}
}