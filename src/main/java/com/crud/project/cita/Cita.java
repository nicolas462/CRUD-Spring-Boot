package com.crud.project.cita;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "CITA")
public class Cita 
{
	@Id
	//@Column(name = "C_ID")
    private int id;
    private int idPaciente;
    private int idMedico;
    private String fechaSolicitada;
    private String fechaAsignada;
    private String horaAsignada;
	
    public int getId() {
		return id;
	}
    
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdPaciente() {
		return idPaciente;
	}
	
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public String getFechaSolicitada() {
		return fechaSolicitada;
	}
	public void setFechaSolicitada(String fechaSolicitada) {
		this.fechaSolicitada = fechaSolicitada;
	}
	public String getFechaAsignada() {
		return fechaAsignada;
	}
	public void setFechaAsignada(String fechaAsignada) {
		this.fechaAsignada = fechaAsignada;
	}
	public String getHoraAsignada() {
		return horaAsignada;
	}
	public void setHoraAsignada(String horaAsignada) {
		this.horaAsignada = horaAsignada;
	}
}
