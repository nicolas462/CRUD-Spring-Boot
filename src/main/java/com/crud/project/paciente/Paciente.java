package com.crud.project.paciente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paciente 
{
	@Id
	private int id;
	private String nombre;
    private String identificacion;
    @Column(name = "tipo_identificacion")
    private String tipoID;
    private String fechaNacimiento;
    private String eps;
    private String historiaClinica;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() { 
		return nombre;
	}
	public String getTipoID() {
		return tipoID;
	}
	public void setTipoID(String tipoID) {
		this.tipoID = tipoID;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getEps() {
		return eps;
	}
	public void setEps(String eps) {
		this.eps = eps;
	}
	public String getHistoriaClinica() {
		return historiaClinica;
	}
	public void setHistoriaClinica(String historiaClinica) {
		this.historiaClinica = historiaClinica;
	}
}
