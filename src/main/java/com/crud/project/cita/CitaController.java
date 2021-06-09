package com.crud.project.cita;

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
public class CitaController {
	
	@Autowired
	CitaService citaService;
	
	@GetMapping("/cita/list")
	public List <Cita> getCitas() {
		return citaService.getCitas();
	}
	
	@PostMapping("/cita/add")
	public void addCita(@RequestBody Cita cita) {
		citaService.addCita(cita);
	}
	
	@PutMapping("/cita/update")
	public void updateCita(@RequestBody Cita cita) {
		citaService.updateCita(cita);
	}
	
	@DeleteMapping("/cita/delete/{id}")
	public void deleteCita(@RequestParam(value = "id") int id) {
		citaService.deleteCita(id);
	}
}
