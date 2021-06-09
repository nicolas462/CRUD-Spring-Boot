package com.crud.project.medico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medico 
{
	@Id
	private int id;
	private String nombre;
    private String identificacion;
    @Column(name = "tipo_identificacion")
    private String tipoID;
    @Column(name = "numero_tarjeta")
    private String numTarjetaProf;
    @Column(name = "anos_experiencia")
    private double anosExp;
    private String especialidad;
    @Column(name = "inicio_atencion")
    private String horaInicio;
    @Column(name = "fin_atencion")
    private String horaFin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
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
	public String getTipoID() {
		return tipoID;
	}
	public void setTipoID(String tipoID) {
		this.tipoID = tipoID;
	}
	public String getNumTarjetaProf() {
		return numTarjetaProf;
	}
	public void setNumTarjetaProf(String numTarjetaProf) {
		this.numTarjetaProf = numTarjetaProf;
	}
	public double getAnosExp() {
		return anosExp;
	}
	public void setAnosExp(double anosExp) {
		this.anosExp = anosExp;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
}
