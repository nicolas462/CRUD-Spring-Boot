package com.crud.project.medico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService 
{
	@Autowired
	MedicoRepository medicoRepository;
	
	public List <Medico> getMedicos()
	{
		List <Medico> listMedicos = new ArrayList<Medico>();
		medicoRepository.findAll().forEach(listMedicos :: add);
		return listMedicos;
	}
	
	public void addMedico(Medico medico)
	{
		medicoRepository.save(medico);
	}
	
	public void updateMedico(Medico medico)
	{
		medicoRepository.save(medico);
	}
	
	public void deleteMedico(int id)
	{
		medicoRepository.deleteById(id);
	}
}
