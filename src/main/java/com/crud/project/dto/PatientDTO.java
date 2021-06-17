package com.crud.project.dto;

import java.io.Serializable;

import com.crud.project.entities.Patient;

public class PatientDTO implements Serializable {

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 2L;
	
	private int id;
	private String name;
	private String identification;
    private String idType;
    private String birthDate;
    private String healthEntity;
    private String clinicHistory;

    public PatientDTO(Patient patient) {
		super();
		this.id = patient.getId();
		this.name = patient.getName();
		this.identification = patient.getIdentification();
		this.idType = patient.getIdType();
		this.birthDate = patient.getBirthDate();
		this.healthEntity = patient.getHealthEntity();
		this.clinicHistory = patient.getClinicHistory();
	}
    public PatientDTO(int id, String name, String identification, String idType, String birthDate, String healthEntity,
			String clinicHistory) {
		super();
		this.id = id;
		this.name = name;
		this.identification = identification;
		this.idType = idType;
		this.birthDate = birthDate;
		this.healthEntity = healthEntity;
		this.clinicHistory = clinicHistory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getHealthEntity() {
		return healthEntity;
	}
	public void setHealthEntity(String healthEntity) {
		this.healthEntity = healthEntity;
	}
	public String getClinicHistory() {
		return clinicHistory;
	}
	public void setClinicHistory(String clinicHistory) {
		this.clinicHistory = clinicHistory;
	}
}
