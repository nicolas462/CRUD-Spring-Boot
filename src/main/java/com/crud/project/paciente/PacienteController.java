package com.crud.project.paciente;

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
public class PacienteController
{
	@Autowired
	PacienteService pacienteService;
	
	@GetMapping("/paciente/list")
	public List <Paciente> getPacientes()
	{
		return pacienteService.getPacientes();
	}
	
	@PostMapping("/paciente/add")
	public void addPaciente(@RequestBody Paciente paciente)
	{
		pacienteService.addPaciente(paciente);
	}
	
	@PutMapping("/paciente/update")
	public void updatePaciente(@RequestBody Paciente paciente)
	{
		pacienteService.updatePaciente(paciente);
	}
	
	@DeleteMapping("/paciente/delete")
	public void deletePaciente(@RequestParam(value = "id") int id)
	{
		pacienteService.deletePaciente(id);
	}
}
