package com.crud.project.cita;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends CrudRepository<Cita, Integer> {

}
