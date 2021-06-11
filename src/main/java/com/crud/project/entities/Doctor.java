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
@Table(name = "DOCTOR")
//@Data
public class Doctor {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCTOR_SEQ")
	@SequenceGenerator (name = "DOCTOR_SEQ", sequenceName="DOCTOR_SEQ", allocationSize=1)
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "IDENTIFICATION")
	private String identification;
    @Column(name = "ID_TYPE")
    private String idType;
    @Column(name = "PROFESIONAL_CARD_NUMBER")
    private String profesionalCardNumber;
    @Column(name = "YEAR_EXP")
    private double yearsExp;
    @Column(name = "SPECIALITY")
    private String speciality;
    @Column(name = "INIT_SCH")
    private String initSch;
    @Column(name = "END_SCH")
    private String endSch;
	
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
}
