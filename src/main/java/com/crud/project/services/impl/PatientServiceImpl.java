package com.crud.project.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.project.entities.Patient;
import com.crud.project.repositories.PatientRepository;
import com.crud.project.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService
{
	@Autowired
	PatientRepository patientRepository;
	
	public List <Patient> getPatients() {
		List <Patient> listPatients = new ArrayList<Patient>();
		patientRepository.findAll().forEach(listPatients :: add);
		return listPatients;
	}
	
	public void addPatient(Patient patient) {
		patientRepository.save(patient);
	}
	
	public void updatePatient(Patient patient)	{
		patientRepository.save(patient);
	}
	
	public void deletePatient(int id) {
		patientRepository.deleteById(id);
	}
}
