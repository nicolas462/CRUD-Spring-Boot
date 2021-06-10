package com.crud.project.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.crud.project.entities.Patient;

@Service
public interface PatientService
{
	public List <Patient> getPatients();
	
	public void addPatient(Patient patient);
	
	public void updatePatient(Patient patient);
	
	public void deletePatient(int id);
}
