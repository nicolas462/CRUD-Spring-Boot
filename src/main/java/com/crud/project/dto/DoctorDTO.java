package com.crud.project.dto;

import java.io.Serializable;

import com.crud.project.entities.Doctor;

public class DoctorDTO implements Serializable {

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String identification;
    private String idType;
    private String profesionalCardNumber;
    private double yearsExp;
    private String speciality;
    private String initSch;
    private String endSch;
    
    public DoctorDTO(Doctor doctor) {
		super();
		this.id = doctor.getId();
		this.name = doctor.getName();
		this.identification = doctor.getIdentification();
		this.idType = doctor.getIdType();
		this.profesionalCardNumber = doctor.getProfesionalCardNumber();
		this.yearsExp = doctor.getYearsExp();
		this.speciality = doctor.getSpeciality();
		this.initSch = doctor.getInitSch();
		this.endSch = doctor.getEndSch();
	}
	public DoctorDTO(int id, String name, String identification, String idType, String profesionalCardNumber,
			double yearsExp, String speciality, String initSch, String endSch) {
		super();
		this.id = id;
		this.name = name;
		this.identification = identification;
		this.idType = idType;
		this.profesionalCardNumber = profesionalCardNumber;
		this.yearsExp = yearsExp;
		this.speciality = speciality;
		this.initSch = initSch;
		this.endSch = endSch;
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
	public String getProfesionalCardNumber() {
		return profesionalCardNumber;
	}
	public void setProfesionalCardNumber(String profesionalCardNumber) {
		this.profesionalCardNumber = profesionalCardNumber;
	}
	public double getYearsExp() {
		return yearsExp;
	}
	public void setYearsExp(double yearsExp) {
		this.yearsExp = yearsExp;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getInitSch() {
		return initSch;
	}
	public void setInitSch(String initSch) {
		this.initSch = initSch;
	}
	public String getEndSch() {
		return endSch;
	}
	public void setEndSch(String endSch) {
		this.endSch = endSch;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
