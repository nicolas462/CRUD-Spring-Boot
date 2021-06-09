package com.crud.project.medico;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Integer> {

}
