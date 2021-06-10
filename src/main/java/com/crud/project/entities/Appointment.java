package com.crud.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "APPOINTMENT")
//@Data
public class Appointment {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APPOINTMENT_SEQ")
	@SequenceGenerator (name = "APPOINTMENT_SEQ", sequenceName="APPOINTMENT_SEQ", allocationSize=1)
	@Column(name = "ID")
    private int id;
	@Column(name = "ID_PATIENT")
    private int idPatient;
	@Column(name = "ID_DOCTOR")
	private int idDoctor;
	@Column(name = "CREATION_DATE")
	private String creationDate;
	@Column(name = "ASSIGNED_DATE")
	private String assignedDate;
	@Column(name = "ASSIGNED_SCH")
	private String assignedSchedule;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	public int getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}
	public String getAssignedSchedule() {
		return assignedSchedule;
	}
	public void setAssignedSchedule(String assignedSchedule) {
		this.assignedSchedule = assignedSchedule;
	}
}
