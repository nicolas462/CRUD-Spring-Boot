package com.crud.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.project.entities.Doctor;

@Service
public interface DoctorService
{
	public List <Doctor> getDoctors();
	
	public void addDoctor(Doctor doctor);
	
	public void updateDoctor(Doctor doctor);
	
	public void deleteDoctor(int id);
	
	public Optional<Doctor> findDoctorById(int id);
}
