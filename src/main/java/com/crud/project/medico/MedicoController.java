package com.crud.project.medico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicoController
{
	@Autowired
	MedicoService medicoService;
	
	@GetMapping("/medico/list")
	public List <Medico> getMedicos()
	{
		return medicoService.getMedicos();
	}
	
	@PostMapping("/medico/add")
	public void addMedico(@RequestBody Medico medico)
	{
		medicoService.addMedico(medico);
	}
	
	@PutMapping("/medico/update")
	public void updateMedico(@RequestBody Medico medico)
	{
		medicoService.updateMedico(medico);
	}
	
	@DeleteMapping("/medico/delete")
	public void deleteMedico(@RequestParam(value = "id") int id)
	{
		medicoService.deleteMedico(id);
	}
}
