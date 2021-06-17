package com.crud.project.dto;

import java.io.Serializable;

import com.crud.project.entities.Appointment;

public class AppointmentDTO implements Serializable {

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 3L;

    private int id;
    private int idPatient;
	private int idDoctor;
	private String creationDate;
	private String assignedDate;
	private String assignedSchedule;
	
	public AppointmentDTO(Appointment appointment) {
		super();
		this.id = appointment.getId();
		this.idPatient = appointment.getIdPatient();
		this.idDoctor = appointment.getIdDoctor();
		this.creationDate = appointment.getCreationDate();
		this.assignedDate = appointment.getAssignedDate();
		this.assignedSchedule = appointment.getAssignedSchedule();
	}	
	public AppointmentDTO(int id, int idPatient, int idDoctor, String creationDate, String assignedDate,
			String assignedSchedule) {
		super();
		this.id = id;
		this.idPatient = idPatient;
		this.idDoctor = idDoctor;
		this.creationDate = creationDate;
		this.assignedDate = assignedDate;
		this.assignedSchedule = assignedSchedule;
	}
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
