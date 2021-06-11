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
@Table(name = "PATIENT")
//@Data
public class Patient {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_SEQ")
	@SequenceGenerator (name = "PATIENT_SEQ", sequenceName="PATIENT_SEQ", allocationSize=1)
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "IDENTIFICATION")
	private String identification;
    @Column(name = "ID_TYPE")
    private String idType;
    @Column(name = "BIRTH_DATE")
    private String birthDate;
    @Column(name = "HEALTH_ENTITY")
    private String healthEntity;
    @Column(name = "CLINIC_HISTORY")
    private String clinicHistory;
	
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
