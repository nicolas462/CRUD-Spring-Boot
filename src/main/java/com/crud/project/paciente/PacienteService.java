package com.crud.project.paciente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService 
{
	@Autowired
	PacienteRepository pacienteRepository;
	
	public List <Paciente> getPacientes()
	{
		List <Paciente> listPacientes = new ArrayList<Paciente>();
		pacienteRepository.findAll().forEach(listPacientes :: add);
		return listPacientes;
	}
	
	public void addPaciente(Paciente paciente)
	{
		pacienteRepository.save(paciente);
	}
	
	public void updatePaciente(Paciente paciente)
	{
		pacienteRepository.save(paciente);
	}
	
	public void deletePaciente(int id)
	{
		pacienteRepository.deleteById(id);
	}
}
