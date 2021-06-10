package com.crud.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.project.entities.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
