package com.crud.project.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.project.entities.Doctor;
import com.crud.project.repositories.DoctorRepository;
import com.crud.project.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService
{
	@Autowired
	DoctorRepository doctorRepository;
	
	public List <Doctor> getDoctors() {
		List <Doctor> listDoctors = new ArrayList<Doctor>();
		doctorRepository.findAll().forEach(listDoctors :: add);
		return listDoctors;
	}
	
	public void addDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
	}
	
	public void updateDoctor(Doctor doctor)	{
		doctorRepository.save(doctor);
	}
	
	public void deleteDoctor(int id) {
		doctorRepository.deleteById(id);
	}
}
