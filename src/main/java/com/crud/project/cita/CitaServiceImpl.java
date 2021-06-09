package com.crud.project.cita;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaServiceImpl implements CitaService 
{
	@Autowired
	CitaRepository citaRepository;
	
	public List <Cita> getCitas()
	{
		List <Cita> listCitas = new ArrayList<Cita>();
		citaRepository.findAll().forEach(listCitas :: add);
		return listCitas;
	}
	
	public void addCita(Cita cita)
	{
		citaRepository.save(cita);
	}
	
	public void updateCita(Cita cita)
	{
		citaRepository.save(cita);
	}
	
	public void deleteCita(int id)
	{
		citaRepository.deleteById(id);
	}
}
