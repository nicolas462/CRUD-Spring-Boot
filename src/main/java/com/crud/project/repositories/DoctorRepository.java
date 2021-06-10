package com.crud.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.project.entities.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

}
