package com.crud.project.cita;

import java.util.List;

public interface CitaService {

	public List <Cita> getCitas();
	public void addCita(Cita cita);
	
	public void updateCita(Cita cita);
	
	public void deleteCita(int id);
}
